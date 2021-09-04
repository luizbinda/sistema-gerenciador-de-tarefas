import {Directive, ElementRef} from '@angular/core';

@Directive({
  selector: '[genericFormFooterButtons]'
})
export class FormFooterButtonsDirective {

  constructor(public el: ElementRef) { }
}
