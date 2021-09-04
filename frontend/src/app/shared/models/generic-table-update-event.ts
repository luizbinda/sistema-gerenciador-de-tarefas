import {Table} from 'primeng/table';
import {DefaultFilter} from './filters/default-filter';

export class GenericTableUpdateEvent {
    table: Table;
    filter?: DefaultFilter;
}
