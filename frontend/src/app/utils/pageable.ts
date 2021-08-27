import {HttpParams} from '@angular/common/http';

export class Pageable {

    page: number;
    size: number;
    sort: string;
    sortOrder: string;

    constructor(page: number, size: number) {
        this.page = page * .1;
        this.size = size;
    }

    setPage(page: number) {
        if (page && page === 0) {
            this.page = 0;
        } else {
            this.page = page;
        }
    }

    setSize(size: number) {
        this.size = (size ? size : 5);
    }

    setSort(sortOrder: number, sortField: string) {
        this.setSortOrder(sortOrder);
        this.sort = sortField + ',' + this.sortOrder;
    }

    setSortTwoParam(sortOrder: number, sortField: string, sortField2: string) {
        this.setSortOrder(sortOrder);
        this.sort = sortField + ',' + sortField2 + ',' + this.sortOrder;
    }

    private setSortOrder(direction: number) {
        this.sortOrder = direction === 1 ? 'ASC' : 'DESC';
    }

    getHttpParms(): HttpParams {
        const httpParams = new HttpParams();
        return httpParams.set("page",String(this.page)).set("size",String(this.size)).set("sort",this.sort);
    }
}
