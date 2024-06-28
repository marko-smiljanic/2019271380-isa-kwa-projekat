import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Recenzija } from '../model/recenzija';

@Injectable({
  providedIn: 'root'
})
export class RecenzijaService {

  elementZaIzmenu: any | null;

  constructor(private client : HttpClient) { }

  getAll(){
    return this.client.get<Recenzija[]>("http://localhost:8080/api/recenzije");
  }
  getOne(id: number){
    return this.client.get<Recenzija>(`http://localhost:8080/api/recenzije/${id}`);
  }
  create(n : Recenzija){
    return this.client.post("http://localhost:8080/api/recenzije", n);
  }
  update(id : number, n : Recenzija){
    return this.client.put(`http://localhost:8080/api/recenzije/${id}`, n);
  }
  delete(id: number){
    return this.client.delete<Recenzija>(`http://localhost:8080/api/recenzije/${id}`);
  }

  setElementZaIzmenu(n: Recenzija){
    this.elementZaIzmenu = n;
  }

}
