import {Directive, ElementRef} from '@angular/core';
import {FormGroupDirective} from '@angular/forms';

@Directive({
  selector: '[genericFormRef]'
})
export class FormRefDirective {
  constructor(public el: ElementRef, public formGroup: FormGroupDirective) { }
}
