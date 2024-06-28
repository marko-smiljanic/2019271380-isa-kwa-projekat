import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Kategorija } from '../model/kategorija';

@Injectable({
  providedIn: 'root'
})
export class KategorijaService {

  elementZaIzmenu: any | null;

  constructor(private client : HttpClient) { }

  getAll(){
    return this.client.get<Kategorija[]>("http://localhost:8080/api/kategorije");
  }
  getOne(id: number){
    return this.client.get<Kategorija>(`http://localhost:8080/api/kategorije/${id}`);
  }
  create(n : Kategorija){
    return this.client.post("http://localhost:8080/api/kategorije", n);
  }
  update(id : number, n : Kategorija){
    return this.client.put(`http://localhost:8080/api/kategorije/${id}`, n);
  }
  delete(id: number){
    return this.client.delete<Kategorija>(`http://localhost:8080/api/kategorije/${id}`);
  }

  setElementZaIzmenu(n: Kategorija){
    this.elementZaIzmenu = n;
  }

}
