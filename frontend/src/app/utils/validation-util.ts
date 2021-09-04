import {AbstractControl, FormGroup, Validators} from '@angular/forms';

export class ValidationUtil {
    private static KEYS = {
        required: 'Campo obrigatório',
        notSame: 'Campo não preenchido',
        '_default': 'Campo obrigatório'
    };

    private static ALPHANUMERIC_REGEX = /^[a-zA-Z0-9]*$/;
    public static NUMERIC_REGEX: RegExp = /^[0-9]*$/;
    public static VALIDATION_EMAIL = `^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$`;
    public static VALIDATION_NUMBER = `^\[0-9]{4}$`;

    public static alphanumeric = Validators.pattern(ValidationUtil.ALPHANUMERIC_REGEX);

    public static getValidationMessages(control: AbstractControl): string[] {
        const messages = [];
        if ((control.dirty || control.touched) && control.errors) {
            Object.entries(control.errors).forEach(
                ([key, _]) => {
                    messages.push(this.KEYS[key] || this.KEYS['_default']);
                }
            );
        }
        return messages;
    }

    public static getErrorMessages(control: AbstractControl): string {
        if (!control) {
            return ' ';
        }
        let keys = ValidationUtil.getValidationMessages(control);
        keys = keys.length ? keys : [' ']; // avoids missing key exception on empty array
        return Object.values(keys).join(', ');
    }

    public static checkPasswords(form: AbstractControl): { notSame: boolean } {
        if (form.get('password').value !== form.get('confirmPassword').value)  {
            form.get('confirmPassword').setErrors({ notSame: true });
            return { notSame: true };
        }
    }

    public static validateForm(form: FormGroup) {
        (<any>Object).values(form.controls).forEach(control => {
            control.markAsTouched();

            if (control.controls) {
                this.validateForm(control);
            }
        });
    }

    public static emptyEditor(control: AbstractControl): { [key: string]: boolean } | null {
        if (control.value && control.value.trim().length === 0) {
            return {emptyEditor: true};
        }
        return null;
    }
}
