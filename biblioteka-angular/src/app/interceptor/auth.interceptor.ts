import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from '../service/login.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private loginServis : LoginService) {}

  //ako token negde postoji napravljen (tj. ako je neko ulogovan) dodaj svakom zahtevu authorization zaglavlje  

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {  
    if(this.loginServis.token){                                                                      
      //request.headers.set():                                                   
      let noviRequest = request.clone({
        headers: request.headers.set("Authorization", this.loginServis.token)    
      });
      return next.handle(noviRequest);                                                                     
    }        
    return next.handle(request);        
  }


}
