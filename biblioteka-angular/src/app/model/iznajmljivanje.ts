import { Knjiga } from "./knjiga";
import { Korisnik } from "./korisnik";

export interface Iznajmljivanje {
    id?: number;
    datumIznajmljivanja: Date;
    datumVracanja: Date;
    korisnik?: Korisnik;
    knjiga?: Knjiga;
}
