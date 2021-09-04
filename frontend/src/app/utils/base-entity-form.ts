import {EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {PageNotificationService} from '@nuvem/primeng-components';
import {BlockUI, NgBlockUI} from 'ng-block-ui';
import {ConfirmationService} from 'primeng/api';
import {catchError, finalize, map, take, takeWhile} from 'rxjs/operators';
import {BaseEntityService} from './base-entity-service';
import {ValidationUtil} from './validation-util';
import {ModalService} from './modal.service';
import {ExportUtil} from './export.util';
import {Observable} from 'rxjs';
import {MessageUtil} from './message-util';

export abstract class BaseEntityForm<T> implements OnInit, OnDestroy {

    protected constructor(
        protected confirmationService: ConfirmationService,
        protected router: Router,
        protected pageNotificationService: PageNotificationService,
        protected formBuilder: FormBuilder,
        protected route: ActivatedRoute,
        protected modalService: ModalService
    ) {
    }

    @BlockUI() blockUI: NgBlockUI;
    @Output() done = new EventEmitter<T | undefined>();
    @Input() modal = false;

    abstract SERVICE: BaseEntityService<T, any>;
    form: FormGroup;
    entityId: number;
    editing = false;
    _alive = true;

    ngOnInit() {
        this.form = this.buildReactiveForm();
        if (!this.editing) {
            this.form.disable();
        }
        this.maybeLoadData();
    }

    abstract buildReactiveForm(): FormGroup;

    downloadFile(doc) {
        ExportUtil.download(doc.file, doc.filename);
    }

    uploadFile(event, onload) {
        const file = event.files[0];
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => {
            onload({ filename: file.name, file: reader.result });
        };
    }

    uploadMultipleFiles(event, onload) {
        event.files.forEach(file => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => {
                onload({ name: file.name, base64: reader.result });
            };
        });
    }

    viewFile(base64) {
        ExportUtil.view(base64);
    }

    maybeLoadData() {
        if (!this.modal) {
            this.route.paramMap.subscribe(_ => {
                const snapshot = this.route.snapshot;
                this.entityId = Number(snapshot.paramMap.get('id'));
                this.editing = snapshot.data.editing;
                this.loadEntity();
            });
        } else {
            this.loadEntity();
        }
    }

    loadEntity() {
        if (this.entityId) {
            this.blockUI.start(MessageUtil.LOADING_SCREEN);
            return this.SERVICE.findById(this.entityId)
                .pipe(
                    takeWhile(_ => this._alive),
                    catchError(err => {
                        this.close();
                        throw err;
                    }),
                    finalize(() => {
                        this.blockUI.stop();
                    }),
                    map((entity: T) => this.onLoadEntity(entity)),
                ).subscribe();
        }
    }

    abstract onLoadEntity(entity: T);

    saveForm(event) {
        if (event) { event.preventDefault(); }

        ValidationUtil.validateForm(this.form);

        if (this.form.valid) {
            const entity: T = this.form.value;
            this.sendForm(entity);
        } else {
            this.pageNotificationService.addErrorMessage(MessageUtil.REQUIRED_FIELDS);
        }
    }

    abstract sendForm(entity: T);

    postAndShowNotification(result: Observable<T>, messageKey: string) {
        this.blockUI.start(MessageUtil.LOADING_SCREEN);

        return result
            .pipe(
                take(1),
                catchError(err => {
                    this.close();
                    throw err;
                }),
                finalize(() => {
                    this.blockUI.stop();
                }),
                map(res => {
                    this.close(res);
                    this.pageNotificationService.addSuccessMessage(messageKey);
                    return res;
                })
            ).subscribe(
                _ => {},
                ({error: {errors}}) => errors.forEach(({defaultMessage}) => this.pageNotificationService.addErrorMessage(defaultMessage))
                );
    }

    isInsert() {
        return this.form.get('id').value === null;
    }

    close(entity?: T) {
        this.modal ? this.done.emit(entity) : this.router.navigate(['../']);
    }

    ngOnDestroy() {
        this._alive = false;
    }

    isEdition() {
        return this.isInsert() || this.editing;
    }

    isMobile() {
        return window.screen.width <= 641;
    }

    formatToDate(date: any): Date {
        if (!date) {
            return null;
        }

        return new Date(`${date}T00:00:00-03:00`);
    }
}
