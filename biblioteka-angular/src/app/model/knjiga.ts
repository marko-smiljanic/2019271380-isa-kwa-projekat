import { Autor } from "./autor";
import { Iznajmljivanje } from "./iznajmljivanje";
import { Kategorija } from "./kategorija";
import { Recenzija } from "./recenzija";

export interface Knjiga {
    id: number,
    naslov: string,
    datumObjave: Date,
    komadaNaStanju?: number,
    cena: number,
    autor?: Autor,
    kategorija: Kategorija,
    recenzije: Recenzija[],
    iznajmljivanja: Iznajmljivanje[];

}
