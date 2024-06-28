import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private loginServis : LoginService) { }


  forma = new FormGroup({
    "username": new FormControl(null, Validators.required),
    "password": new FormControl(null, Validators.required)
  });


  ngOnInit(): void {
  }

  ulogujSe(){
    if(this.forma.valid){
      console.log(this.forma.value);
      this.loginServis.login(this.forma.value).subscribe(_ => {
        
      });
    }
  }

}
