import {Component, OnInit} from '@angular/core';
import {BlockUI, NgBlockUI} from 'ng-block-ui';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ConfirmationService} from 'primeng/api';
import {ActivatedRoute, Router} from '@angular/router';
import {PageNotificationService} from '@nuvem/primeng-components';
import {ResponsavelModel} from '../../shared-models/responsavel-model';
import {ModalService} from '../../utils/modal.service';
import {ResponsavelService} from '../../shared-services/responsavel-service';
import {BaseEntityForm} from '../../utils/base-entity-form';
import {HomeMesages} from '../home-mesages';

@Component({
    selector: 'app-responsavel-form',
    templateUrl: './responsavel-form.component.html',
    styleUrls: ['responsavel-form.component.scss']
})
export class ResponsavelFormComponent extends BaseEntityForm<ResponsavelModel> implements OnInit {
    SERVICE = this.responsavelService;
    MSG = HomeMesages;
    form: FormGroup;

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
            nome: [null, [Validators.required]],
            dataNascimento: [null, [Validators.required]],
            email: [null, [Validators.required]],
        }, {updateOn: 'change'});
    }

    closeModal(): void {
        this.close();
    }
}
