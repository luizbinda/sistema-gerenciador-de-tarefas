import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {ResponsavelModel} from '../shared-models/responsavel-model';
import {BaseEntityService} from '../utils/base-entity-service';

@Injectable()
export class ResponsavelService extends BaseEntityService<ResponsavelModel, any> {

    getEntity(): string {
        return 'responsavel';
    }

    constructor(protected http: HttpClient) {
        super(http);
    }

}
