import {Directive, ElementRef} from '@angular/core';

@Directive({
  selector: '[genericFormHeader]'
})
export class FormHeaderDirective {

  constructor(public el: ElementRef) { }
}
