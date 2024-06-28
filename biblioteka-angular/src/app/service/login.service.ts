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

  constructor(private client : HttpClient) { }

  login(user: User){      
    return this.client.post<Token>("http://localhost:8080/api/login", user).pipe(
      tap(tt => {
        this.token = tt.token;
        this.userr = JSON.parse(atob(tt.token.split(".")[1]))        //atob je dekodovanje base64 zapisanog tokena
        console.log(this.userr);
      })
    );
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
