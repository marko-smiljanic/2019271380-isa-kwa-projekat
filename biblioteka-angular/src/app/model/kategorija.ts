import { Knjiga } from "./knjiga";

export interface Kategorija {
    id?: number;
    naziv: string;
    knjige?: Knjiga[];
}
