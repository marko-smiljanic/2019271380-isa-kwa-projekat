import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Iznajmljivanje } from '../model/iznajmljivanje';

@Injectable({
  providedIn: 'root'
})
export class IznajmljivanjeService {

  elementZaIzmenu: any | null;

  constructor(private client : HttpClient) { }

  getAll(){
    return this.client.get<Iznajmljivanje[]>("http://localhost:8080/api/iznajmljivanja");
  }
  getOne(id: number){
    return this.client.get<Iznajmljivanje>(`http://localhost:8080/api/iznajmljivanja/${id}`);
  }
  create(n : Iznajmljivanje){
    return this.client.post("http://localhost:8080/api/iznajmljivanja", n);
  }
  update(id : number, n : Iznajmljivanje){
    return this.client.put(`http://localhost:8080/api/iznajmljivanja/${id}`, n);
  }
  delete(id: number){
    return this.client.delete<Iznajmljivanje>(`http://localhost:8080/api/iznajmljivanja/${id}`);
  }

  setElementZaIzmenu(n: Iznajmljivanje){
    this.elementZaIzmenu = n;
  }
}
