import { Knjiga } from "./knjiga";

export interface Autor {
    id?: number,
    ime: string,
    prezime: string,
    knjige?: Knjiga[];
}
