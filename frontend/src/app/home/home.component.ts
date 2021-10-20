import {Component, OnInit, ViewChild} from '@angular/core';
import {ResponsavelService} from '../shared-services/responsavel-service';
import {GenericTableComponent} from '../components/generic-table/generic-table.component';
import {GenericTableUpdateEvent} from '../shared/models/generic-table-update-event';
import {BlockUI, NgBlockUI} from 'ng-block-ui';
import {finalize} from 'rxjs/operators';
import {HomeUtil} from './home-util';
import {HomeMesages} from './home-mesages';
import {ModalService} from '../utils/modal.service';
import {ResponsavelFormModalComponent} from './reponsavel-form/responsavel-form-modal.component';
import {MessageUtil} from '../utils/message-util';
import {GenericTableButton} from '../shared/models/generic-table-button';
import {ResponsavelModel} from '../shared-models/responsavel-model';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.component.scss']
})
export class HomeComponent implements OnInit {
    SERVICE = this.responsavelService;
    MSG = HomeMesages;
    COLUMNS = HomeUtil.COLUMNS;
    FILTERS = HomeUtil.FILTERS;
    BUTTONS: GenericTableButton<ResponsavelModel>[]  = [
        {
            icon: 'edit',
            description: MessageUtil.EDIT,
            action: responsavel => this.openResponsavelModal(responsavel)
        },
        {
            icon: 'remove-red-eye',
            description: MessageUtil.VIEW,
            action: responsavel => this.openResponsavelModal(responsavel, false)
        }
    ];

    @ViewChild('tableUser') tableUser: GenericTableComponent;
    @BlockUI() blockUI: NgBlockUI;

    constructor(
        private responsavelService: ResponsavelService,
        private modalService: ModalService,
    ) { }

    ngOnInit() { }

    updateTable(event?: GenericTableUpdateEvent) {
        this.blockUI.start();
        this.SERVICE.search(event?.table, event?.filter.query || null)
            .pipe(finalize(() => this.blockUI.stop()))
            .subscribe(responsaveis => this.tableUser.result = responsaveis);
    }

    openResponsavelModal(resposanvel?: ResponsavelModel, editing = true): void {
        const responsabelmodel = this.modalService.openModal(ResponsavelFormModalComponent, {}, {resposanvel, editing});
        responsabelmodel.onClose.subscribe(entity => !entity || this.updateTable());
    }

}
