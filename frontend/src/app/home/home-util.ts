import {GenericTableColumn} from '../shared/models/generic-table-column';
import {GenericTableButton} from '../shared/models/generic-table-button';
import {MessageUtil} from '../utils/message-util';
import {GenericTableFilter} from '../shared/models/generic-table-filter';

export class HomeUtil {
    static COLUMNS: GenericTableColumn[] = [
        { field: 'id', header: 'id' },
        { field: 'nome', header: 'Nome' },
        { field: 'dataNascimento', header: 'Data de Nascimento' },
        { field: 'email', header: 'Email' },
        { field: 'status', header: 'Status' }
    ];
    static BUTTONS: GenericTableButton<any>[] = [
        {
            icon: 'person',
            description: MessageUtil.NEW,
            action: _ => {}
        }
    ];
    static FILTERS: GenericTableFilter[] = [
        {
            field: 'nome',
            type: 'string',
            label: MessageUtil.LABELS_FILTER
        }
    ];
}
