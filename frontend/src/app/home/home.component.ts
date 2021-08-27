import {Component, OnInit, ViewChild} from '@angular/core';
import {LazyLoadEvent, Table} from 'primeng';
import {ResponsavelModel} from '../shared-models/responsavel-model';
import {ResponsavelService} from '../shared-services/responsavel-service';
import {Pageable} from '../utils/pageable';
import {finalize} from 'rxjs/operators';
import {Page} from '../utils/page';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.component.scss']
})
export class HomeComponent implements OnInit {

    responsavelFilter = new ResponsavelModel();
    page = new Page<ResponsavelModel>();
    pageable = new Pageable(0, 1);
    statuses: any[];
    loading = true;
    cols = [
        { field: 'id', header: 'id' },
        { field: 'nome', header: 'Nome' },
        { field: 'dataNascimento', header: 'Data de Nascimento' },
        { field: 'email', header: 'Email' },
        { field: 'status', header: 'Status' }
    ];

    @ViewChild('table') table: Table;

    constructor(private responsavelService: ResponsavelService) { }

    ngOnInit() {
        const pageable = new Pageable(0, 2);
        this.responsavelService.getAllResponsaveis(pageable, this.responsavelFilter)
            .pipe(finalize(() => this.loading = false))
            .subscribe(responsaveis => this.page = responsaveis);
    }

    getAllResponsaveis(event?: LazyLoadEvent) {
        this.loading = true;
        this.pageable.page = 0;
        if (event) {
            this.pageable.page = event.first;
        }
        this.responsavelService.getAllResponsaveis(this.pageable, this.responsavelFilter)
            .pipe(finalize(() => this.loading = false))
            .subscribe(responsaveis => this.page = responsaveis);
    }


    onDateSelect(value?) {
        this.responsavelFilter.dataNascimento = null;
        if (value) {
            this.responsavelFilter.dataNascimento = new Date(value).toLocaleDateString('en-CA');
        }
        this.getAllResponsaveis();
    }
}
