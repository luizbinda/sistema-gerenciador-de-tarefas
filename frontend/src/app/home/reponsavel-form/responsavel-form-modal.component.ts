import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {DynamicDialogConfig, DynamicDialogRef} from 'primeng';
import {ResponsavelFormComponent} from './responsavel-form.component';


@Component({
    selector: 'app-responsavel-form-modal',
    template: '<app-responsavel-form #form [modal]="true" (done)="ref.close($event)"></app-responsavel-form>'
})
export class ResponsavelFormModalComponent implements AfterViewInit {
    constructor(public config: DynamicDialogConfig, public ref: DynamicDialogRef) {
    }

    @ViewChild('form') form: ResponsavelFormComponent;

    ngAfterViewInit(): void {
        setTimeout(() => this.initAtributes());
    }

    private initAtributes(): void {
        if (!this.config.data) {
            return;
        }

        this.form.editing = this.config.data.editing;
        if (!this.config.data.editing) {
            this.form.form.disable();
        }

        if (this.config.data.resposanvel) {
            this.form.form.patchValue({
                ...this.config.data.resposanvel,
                dataNascimento: new Date(this.config.data.resposanvel.dataNascimento)
            });
        }
    }

}
