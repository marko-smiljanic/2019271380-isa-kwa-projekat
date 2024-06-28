import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Knjiga } from '../model/knjiga';

@Injectable({
  providedIn: 'root'
})
export class KnjigaService {

  elementZaIzmenu: any | null;

  constructor(private client : HttpClient) { }

  getAll(){
    return this.client.get<Knjiga[]>("http://localhost:8080/api/knjige");
  }
  getOne(id: number){
    return this.client.get<Knjiga>(`http://localhost:8080/api/knjige/${id}`);
  }
  create(n : Knjiga){
    return this.client.post("http://localhost:8080/api/knjige", n);
  }
  update(id : number, n : Knjiga){
    return this.client.put(`http://localhost:8080/api/knjige/${id}`, n);
  }
  delete(id: number){
    return this.client.delete<Knjiga>(`http://localhost:8080/api/knjige/${id}`);
  }

  setElementZaIzmenu(n: Knjiga){
    this.elementZaIzmenu = n;
  }

}
