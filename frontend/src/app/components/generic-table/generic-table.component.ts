import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Table} from 'primeng/table';
import {GenericTableColumn} from '../../shared/models/generic-table-column';
import {GenericTableButton} from '../../shared/models/generic-table-button';
import {GenericTableFilter} from '../../shared/models/generic-table-filter';
import {GenericTableUpdateEvent} from '../../shared/models/generic-table-update-event';
import {GenericTableSelectedRow} from '../../shared/models/generic-table-selected-row';
import {Page} from '../../utils/page';
import {MessageUtil} from '../../utils/message-util';

@Component({
  selector: 'app-generic-table',
  templateUrl: './generic-table.component.html',
  styleUrls: ['./generic-table.component.css']
})
export class GenericTableComponent implements OnInit {
  @Input() result = new Page<any>();
  @Input() columns: GenericTableColumn[];
  @Input() buttons: GenericTableButton<any>[] = [];
  @Input() showGlobalFilter = false;
  @Input() filters: GenericTableFilter[] = [];
  @Input() paginator = true;
  @Input() showExportButton = false;
  @Input() rowsPerPage = [20, 30, 40, 50];
  @Input() multiselect = false;
  @Input() view = false;
  @Input() changeStyle: any;

  @Output() loadItems = new EventEmitter<GenericTableUpdateEvent>();
  @Output() export = new EventEmitter<GenericTableUpdateEvent>();
  @Input() customPaginator = false;
  disableNextButton = false;

  @ViewChild(Table) table: Table;

  globalFilter = '';
  columnFilters: any = {};
  MSG = MessageUtil;
  rowsPerPageSelect = [];

  private selectedRows: GenericTableSelectedRow[] = [];
  disableButtons: boolean[] = [];

  constructor() { }

  ngOnInit() {
    this.rowsPerPageSelect = this.getRowsPerPageSelect();
    this.disbaleButton();
  }

  changeStyleRow(row) {
    return !!this.changeStyle ? this.changeStyle(row) : 'row content';
  }

  refreshTable() {
    this.loadItems.emit({
      table: this.table,
      filter: {
        query: this.globalFilter,
        ...this.columnFilters
      },
    });
  }

  getColumnsLength(): number {
    return this.columns.length + 2;
  }

  getColumnFilter(col: GenericTableColumn): GenericTableFilter {
      const filter = this.filters.find(f => f.field === col.field) || {} as GenericTableFilter;
      return filter;
  }

  getColumnValue(col: any, field: string) {
    if (!field.includes('.')) {
      return col[field];
    }

    return this.resolve(field, col);
  }

  resolve(path, obj) {
    return path.split('.').reduce((prev, curr) => {
        return prev ? prev[curr] : null;
    }, obj || self);
  }

  hasButtons() {
    return this.buttons.length && this.buttons.some(btn => btn.hideButton ? !btn.hideButton() : true);
  }

  hasButtonsDisable(): boolean {
    return this.buttons.length && this.buttons.some(btn => !!btn.disable);
  }

  getFirstIndex() {
    return this.result.number * this.result.size + 1 || 0;
  }

  getLastIndex() {
    return this.result.number * this.result.size + this.result.numberOfElements || 0;
  }

  exportCsv(event) {
    event.preventDefault();
    this.export.emit({
      table: this.table,
      filter: {
        query: this.globalFilter,
        ...this.columnFilters
      },
    });
  }

  changeAction(rowData, button: GenericTableButton<any>, multiple) {
    if (button.disable && button.disable(rowData)) {
      return;
    }

    if (multiple) {
      button.action(this.selectedRows);
      return;
    }
    button.action(rowData);
  }

  getSelectedRows() {
    return this.selectedRows.map(row => row.data);
  }

  getSizeSelectedRows() {
    return this.selectedRows.map(row => row.data).length;
  }

  clearCheck() {
      this.selectedRows.forEach(row => row.control.checked = false);
      this.selectedRows = [];
  }

  removeSelectedRows(selectedRows) {
    if (selectedRows instanceof Array) {
      this.result.content = this.result.content.filter(obj => !selectedRows.map(result => result.data).includes(obj));
    } else {
      this.result.content = this.result.content.filter(obj => obj !== selectedRows);
    }

    this.selectedRows = [];
  }

  changeRow(rowData, control) {
    const index = this.getSelectedRows().findIndex(element => element === rowData);

    if (index !== -1) {
      this.selectedRows.splice(index, 1);
      this.disbaleButton();
      return;
    }

    const selectedRow = new GenericTableSelectedRow();
    selectedRow.data = rowData;
    selectedRow.control = control;
    this.selectedRows.push(selectedRow);
    this.disbaleButton();
  }

  disbaleButton() {
    if (this.hasButtonsDisable()) {
      this.disableButtons = this.buttons.map(btn => btn.disable ? btn.disable(this.selectedRows) : false);
    }
  }

  verifyDisableButton(index: number): boolean {
    return this.disableButtons[index];
  }

  getDisableButtonClass(btn, rowData): string {
    if (!btn.disable) {
      return '';
    }
    return !btn.disable(rowData) ? '' : 'table-button-disable';
  }

  hideHeaderButton(btn: GenericTableButton<any>) {
    return btn.hideButton ? (btn.multiple && !btn.hideButton()) : true;
  }

  nextPage() {
    this.table.first = this.table.first + this.table.rows;
    this.refreshTable();
  }

  previousPage() {
    if (!this.invalidPreviousPage()) {
      this.rollbackPage();
      this.refreshTable();
      this.disableNextButton = false;
    }
  }

  rollbackPage() {
    this.table.first = this.table.first - this.table.rows;
  }

  invalidPreviousPage() {
    return (this.table.first - this.table.rows) < 0;
  }

  getRowsPerPageSelect() {
    return this.rowsPerPage.map(element => ({value: element, label: element}));
  }

  changeRowPerPage(event) {
    this.table.rows = event.value;
    this.refreshTable();
  }

}
