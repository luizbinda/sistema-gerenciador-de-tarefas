export class GenericTableButton<T> {
    icon: string;
    description: string;
    action: (row: T) => void;
    disable?: (row: T) => boolean;
    hideButton?: (row?: T) => boolean;
    multiple?: boolean = false;
}
