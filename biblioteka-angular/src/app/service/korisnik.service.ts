import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Korisnik } from '../model/korisnik';

@Injectable({
  providedIn: 'root'
})
export class KorisnikService {

  elementZaIzmenu: any | null;

  constructor(private client : HttpClient) { }

  getAll(){
    return this.client.get<Korisnik[]>("http://localhost:8080/api/korisnici");
  }
  getOne(id: number){
    return this.client.get<Korisnik>(`http://localhost:8080/api/korisnici/${id}`);
  }
  create(n : Korisnik){
    return this.client.post("http://localhost:8080/api/korisnici", n);
  }
  update(id : number, n : Korisnik){
    return this.client.put(`http://localhost:8080/api/korisnici/${id}`, n);
  }
  delete(id: number){
    return this.client.delete<Korisnik>(`http://localhost:8080/api/korisnici/${id}`);
  }

  setElementZaIzmenu(n: Korisnik){
    this.elementZaIzmenu = n;
  }

}
