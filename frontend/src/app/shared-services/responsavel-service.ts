import {HttpClient, HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Pageable} from '../utils/pageable';
import {Page} from '../utils/page';
import {ResponsavelModel} from '../shared-models/responsavel-model';

@Injectable()
export class ResponsavelService {

    private url = 'api/responsavel';

    constructor(private http: HttpClient) { }

    getAllResponsaveis(pageable: Pageable, filter?: ResponsavelModel): Observable<Page<ResponsavelModel>> {
        let params = new HttpParams();
        params = params.append('size', `${pageable.size}`);
        params = params.append('page', `${pageable.page}`);
        if (filter) {
            Object.keys(filter).forEach(key => {
                if (filter[key]) {
                    params = params.append(key, `${filter[key]}`);
                }
            });
        }
        return this.http.get<Page<ResponsavelModel>>(`${this.url}/index`, {params});
    }

}
