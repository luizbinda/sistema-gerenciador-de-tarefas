import { HttpParams } from '@angular/common/http';
import { Table } from 'primeng/table';

export class RequestUtil {

    static getRequestParamsTable = (datatable: Table, query: string): HttpParams => {
        let params: HttpParams = new HttpParams();
        if (datatable == null) {
            params = params.append('size', '10');
            return params;
        }

        params = params.append('page', Math.round(datatable.first / datatable.rows).toString());
        params = params.append('size', datatable.rows == null ? '10' : datatable.rows.toString());

        const direction = datatable.sortOrder === 1 ? 'ASC' : 'DESC';
        params = params.append('sort', datatable.sortField == null ? 'id,DESC' : datatable.sortField + ',' + direction);
        if (query) {
            params = params.append('query', query);
        }
        return params;
    }

    static getRequestParams = (obj: Object): HttpParams => {
        let params: HttpParams = new HttpParams();

        if (obj) {
            Object.keys(obj).forEach(param => {
                if (obj[param] !== null) {
                    params = params.append(param, obj[param]);
                }
            });
        }

        return params;
    }

}
