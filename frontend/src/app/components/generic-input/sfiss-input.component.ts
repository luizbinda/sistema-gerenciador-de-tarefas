import {Component, ContentChild} from '@angular/core';
import {InputRefDirective} from './input-ref.directive';
import {ValidationUtil} from '../../utils/validation-util';

@Component({
  selector: 'app-generic-input',
  templateUrl: './sfiss-input.component.html',
  styleUrls: ['./sfiss-input.component.css']
})
export class SfissInputComponent {
  @ContentChild(InputRefDirective) input: InputRefDirective;

  constructor() { }

  getValidationMessage(): string {
    return ValidationUtil.getErrorMessages(this.input.control);
  }
}
