import { Injectable } from '@angular/core';
import { Autor } from '../model/autor';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AutorService {
  
  elementZaIzmenu: any | null;

  constructor(private client : HttpClient) { }

  getAll(){
    return this.client.get<Autor[]>("http://localhost:8080/api/autori");
  }
  getOne(id: number){
    return this.client.get<Autor>(`http://localhost:8080/api/autori/${id}`);
  }
  create(n : Autor){
    return this.client.post("http://localhost:8080/api/autori", n);
  }
  update(id : number, n : Autor){
    return this.client.put(`http://localhost:8080/api/autori/${id}`, n);
  }
  delete(id: number){
    return this.client.delete<Autor>(`http://localhost:8080/api/autori/${id}`);
  }

  setElementZaIzmenu(n: Autor){
    this.elementZaIzmenu = n;
  }
}
