import {Directive, Input, Optional} from '@angular/core';
import {AbstractControl, FormControlName, NgControl, ReactiveFormsModule} from '@angular/forms';

@Directive({
    selector: '[sInputRef]',
    providers: [ReactiveFormsModule]
})
export class InputRefDirective {
    @Input() sLabel: string;
    control: AbstractControl;

    constructor(public formControl: NgControl, @Optional() public formControlName?: FormControlName)  { }
}
