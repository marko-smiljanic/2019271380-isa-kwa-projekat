import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';
import { User } from '../model/user';
import { Token } from '../model/token';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  token : null | string = null;        
  userr: any = null;


  constructor(private client : HttpClient) { 
    const sacuvanToken = localStorage.getItem('accessToken');
    if (sacuvanToken) {
      this.token = sacuvanToken;
      this.userr = JSON.parse(atob(sacuvanToken.split(".")[1]));
    }
  }


  login(user: User){    
    //za svaki slucaj, ako je neko vec bio ulogovan da se staro obrise, jer u razvoju ulogovacu se brdo puta sa drugim korisnicima
    localStorage.removeItem('accessToken');

    return this.client.post<Token>("http://localhost:8080/api/login", user).pipe(
      tap(tt => {
        this.token = tt.token;
        this.userr = JSON.parse(atob(tt.token.split(".")[1]))         //atob je dekodovanje base64 zapisanog tokena
        console.log(this.userr);
        localStorage.setItem('accessToken', tt.token);  //ako je uspesno logovanje cuvamo u local storage token
      })
    );
  }

  logout(){
    this.token = null;
    this.userr = null;
    localStorage.removeItem('accessToken');
    window.location.reload();   //zbog reseta prikaza
  }


  daLiJeNekoUlogovan(){
    if(this.userr != null){
      return true;
    }else{
      return false;
    }
  }

  validateRoles(roles: any, method="any"){            
    if(this.userr){                                   
      let userRoles = new Set(this.userr.roles);
      let intersection = new Set();

      for(let r of roles){                         
        if(userRoles.has(r)){
          intersection.add(r);          
        }
      }

      console.log("interesection: " , intersection);
      console.log("userRoles: ", userRoles);
      console.log("prosledjeni (trazeni) roles: ", roles);

      roles = new Set(roles);                       

      if(method == "any"){
        return intersection.size > 0;                     //vraca true or false  
      }else if(method == "all"){
        return intersection.size == roles.size;      
      }
    } 
    return false;
  }


  

}
