import {HttpClient} from '@angular/common/http';
import { SelectItem } from 'primeng/api';
import {Table} from 'primeng/table';
import {Observable} from 'rxjs';
import {Page} from './page';
import {RequestUtil} from './request-util';

export abstract class BaseEntityService<T, Y> {

    protected constructor(protected http: HttpClient) { }

    resourceUrl =  'api/' + this.getEntity();

    abstract getEntity(): string;

    search(table: Table, query = ''): Observable<Page<Y>> {
        return this.http.get<Page<Y>>(this.resourceUrl + '/search',
            {
                params: RequestUtil.getRequestParamsTable(table, query)
            }
        );
    }

    insert(entity: T): Observable<T> {
        return this.http.post<T>(this.resourceUrl, entity);
    }

    findById(id: number): Observable<T> {
        return this.http.get<T>(this.resourceUrl + '/' + id);
    }

    findAll(): Observable<T[]> {
        return this.http.get<T[]>(this.resourceUrl);
    }

    update(entity: T): Observable<T> {
        return this.http.put<T>(this.resourceUrl, entity);
    }

    delete(id: number): Observable<void> {
        return this.http.delete<void>(this.resourceUrl + '/' + id);
    }

    findAllDropDown(): Observable<SelectItem[]> {
        return this.http.get<SelectItem[]>(this.resourceUrl + '/select');
    }

}
