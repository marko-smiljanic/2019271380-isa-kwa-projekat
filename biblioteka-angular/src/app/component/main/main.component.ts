import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(private loginServis: LoginService) { }

  ngOnInit(): void {
  }

  validirajUloge(uloge: any) {
    return this.loginServis.validateRoles(uloge);
  }

  izlogujSe(){
    this.loginServis.logout();
  }

  daLiJeNekoUlogovan(){
    return this.loginServis.daLiJeNekoUlogovan();
  }




}
