import {
    AfterContentInit,
    AfterViewInit,
    Component,
    ContentChild,
    ContentChildren,
    Input,
    QueryList
} from '@angular/core';
import {FormFooterButtonsDirective} from './form-footer-buttons.directive';
import {FormHeaderDirective} from './form-header.directive';
import {FormRefDirective} from './form-ref.directive';
import {MessageUtil} from '../../utils/message-util';
import {InputRefDirective} from '../generic-input/input-ref.directive';

@Component({
  selector: 'app-generic-form',
  templateUrl: './generic-form.component.html',
  styleUrls: ['./generic-form.component.css']
})
export class GenericFormComponent implements AfterViewInit, AfterContentInit {
    @ContentChild(FormRefDirective) form: FormRefDirective;
    @ContentChild(FormHeaderDirective) formHeader: FormHeaderDirective;
    @ContentChild(FormFooterButtonsDirective) formButtons: FormFooterButtonsDirective;
    @ContentChildren(InputRefDirective, { descendants: true }) inputs: QueryList<InputRefDirective>;
    @Input() modal = false;
    MSGS = MessageUtil;

    constructor() { }

    ngAfterViewInit() {
        this.form.el.nativeElement.className += this.getCardClass();
        this.formHeader.el.nativeElement.className += this.getHeaderClass();
        this.formButtons.el.nativeElement.className += ' sfiss-form-buttons';
        this.formButtons.el.nativeElement.className += this.getFooterClass();
    }

    ngAfterContentInit() {
        this.inputs.forEach(i =>
            i.control = i.formControl ? i.formControl as any : this.form.formGroup.form.get(i.formControlName.name as string)
        );
    }

    getFooterClass() {
        return this.modal ? ' ui-dialog ui-dialog-footer sfiss-dialog-footer' : '';
    }

    getHeaderClass() {
        return this.modal ? ' ui-dialog ui-dialog-header sfiss-dialog-title' : '';

    }

    getCardClass() {
        return !this.modal ? ' card card-w-title' : '';
    }
}
