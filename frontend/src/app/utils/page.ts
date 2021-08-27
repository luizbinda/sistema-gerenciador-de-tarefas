export class Page<T> {
    content: T[] = [];
    last: boolean;
    totalElements: number;
    totalPages: number;
    size: number;
    number: number;
    numberOfElements: number;
    sort: string;
    first: boolean;

    constructor(content?, totalElements?) {
        this.content = content;
        if (totalElements) {
            this.totalElements = totalElements;
        } else {
            this.totalElements = 0;
        }
    }
}
