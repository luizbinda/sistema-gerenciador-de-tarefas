import { Injectable } from '@angular/core';
import {DialogService, DynamicDialogRef} from 'primeng';

@Injectable()
export class ModalService {

    constructor(private dialogService: DialogService) { }

    /**
     * Returns a @DynamicDialogRef
     * use #onClose to return data from dialog
     * use #close or #destroy to close dialog
     */
    openModal(component: any, size: { width?: string; height?: string; }, data?: Object): DynamicDialogRef {
        const maxHeight = '75vh';
        return this.dialogService.open(component, {
            width: size.width || '75rem',
            height: size.height || '85vh',
            baseZIndex: 2000,
            closable: true,
            data: data ? data : null,
            footer: '', // place footer element on dialog so we can override it
            contentStyle: {
                'max-height': maxHeight,
                overflow: 'auto',
                height: '100%'
            },
            style: {
                'max-width': '100%',
            }
        });
    }
}
