import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Korisnik } from 'src/app/model/korisnik';
import { User } from 'src/app/model/user';
import { KorisnikService } from 'src/app/service/korisnik.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  elementi: Korisnik[] = [];

  forma = new FormGroup({
    "korisnickoIme": new FormControl(null, Validators.required),
    "lozinka": new FormControl(null, Validators.required),
    "ime": new FormControl(null, Validators.required),
    "prezime": new FormControl(null, Validators.required)
  });

  constructor(private loginServis : LoginService, private router: Router, private korisnikServis: KorisnikService) { }

  ngOnInit(): void {
  }


  ulogujSe(){
    //pravim user objekat, setujem kor ime i lozinku i logujem se sa njim
    if(this.forma.valid){
      let user = {
        korisnickoIme: this.forma.value.korisnickoIme,
        lozinka: this.forma.value.lozinka
      };

      console.log(user);
      this.loginServis.login(user).subscribe(_ => {
        this.router.navigate(["knjiga-prikaz"]);
      });
    }
  }

  registrujSe(){
    if(this.forma.valid){
        this.korisnikServis.create(this.forma.value).subscribe(_ =>{
          this.korisnikServis.getAll().subscribe(x =>{
            this.elementi = x;

            //odmah ga i ulogujem
            this.ulogujSe();
            this.router.navigate(["/"]);
          });
      });
    } 
  }


}
