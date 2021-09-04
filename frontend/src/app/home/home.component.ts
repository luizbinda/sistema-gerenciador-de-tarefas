import {Component, OnInit, ViewChild} from '@angular/core';
import {ResponsavelService} from '../shared-services/responsavel-service';
import {GenericTableColumn} from '../shared/models/generic-table-column';
import {GenericTableButton} from '../shared/models/generic-table-button';
import {MessageUtil} from '../utils/message-util';
import {GenericTableComponent} from '../components/generic-table/generic-table.component';
import {GenericTableFilter} from '../shared/models/generic-table-filter';
import {GenericTableUpdateEvent} from '../shared/models/generic-table-update-event';
import {BlockUI, NgBlockUI} from 'ng-block-ui';
import {finalize} from 'rxjs/operators';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ValidationUtil} from '../utils/validation-util';
import {BaseEntityForm} from '../utils/base-entity-form';
import {ResponsavelModel} from '../shared-models/responsavel-model';
import {HomeUtil} from './home-util';
import {ConfirmationService} from 'primeng/api';
import {ActivatedRoute, Router} from '@angular/router';
import {PageNotificationService} from '@nuvem/primeng-components';
import {ModalService} from '../utils/modal.service';
import {HomeMesages} from './home-mesages';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.component.scss']
})
export class HomeComponent extends BaseEntityForm<ResponsavelModel> implements OnInit {
    SERVICE = this.responsavelService;
    COLUMNS = HomeUtil.COLUMNS;
    BUTTONS = HomeUtil.BUTTONS;
    FILTERS = HomeUtil.FILTERS;
    MSG = HomeMesages;
    form: FormGroup;

    @ViewChild('tableUser') tableUser: GenericTableComponent;
    @BlockUI() blockUI: NgBlockUI;

    constructor(
        private responsavelService: ResponsavelService,
        protected confirmationService: ConfirmationService,
        protected router: Router,
        protected pageNotificationService: PageNotificationService,
        protected formBuilder: FormBuilder,
        protected route: ActivatedRoute,
        protected modalService: ModalService
    ) {
        super(confirmationService, router, pageNotificationService, formBuilder, route, modalService);
    }

    ngOnInit() {
        this.form = this.buildReactiveForm();
    }

    onLoadEntity(entity: ResponsavelModel) {
        throw new Error('Method not implemented.');
    }

    sendForm(responsavel: ResponsavelModel) {
        this.postAndShowNotification(
            this.SERVICE.insert(responsavel),
            this.MSG.RESPONSAVEL_SAVE_SUCESS
        );
    }

    buildReactiveForm() {
        return this.formBuilder.group({
            id: [null],
            nome: [null, [Validators.required, Validators.maxLength(10)]],
            dataNascimento: [null, []],
            email: [null, [Validators.required, Validators.maxLength(255)]],
        }, {updateOn: 'change'});
    }

    updateTable(event?: GenericTableUpdateEvent) {
        this.blockUI.start();
        this.SERVICE.search(event.table, event.filter.query)
            .pipe(finalize(() => this.blockUI.stop()))
            .subscribe(responsaveis => this.tableUser.result = responsaveis);
    }

    clearForm() {
        this.form.reset();
    }
}
