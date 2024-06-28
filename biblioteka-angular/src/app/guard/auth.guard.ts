import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../service/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private loginServis: LoginService){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    console.log(this.loginServis.userr);
    
    if(this.loginServis.validateRoles(route.data["allowedRoles"], route.data["validationMethod"])){        //ovo je za pristup celim rutama, za pristup funkcionalnostima moram validate roles da proveravam u html-u
      return true;                                                                                      
    }
    return this.router.createUrlTree(["login"]);                                                         
  }
  
}
