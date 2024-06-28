import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Knjiga } from 'src/app/model/knjiga';
import { KnjigaService } from 'src/app/service/knjiga.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-knjiga-prikaz',
  templateUrl: './knjiga-prikaz.component.html',
  styleUrls: ['./knjiga-prikaz.component.css']
})
export class KnjigaPrikazComponent implements OnInit {

  elements: Knjiga[] = [];

  constructor(private knjigaServis: KnjigaService, private router : Router, private loginServis: LoginService) { 
    this.knjigaServis.getAll().subscribe(x=> {
      this.elements = x;
      console.log(x);
    })
  }

  ngOnInit(): void {
    
  }

  izbrisi(id: number){
    this.knjigaServis.delete(id).subscribe(_=> {
      this.knjigaServis.getAll().subscribe(x=> {
        this.elements = x;
      })
    })
  }

  proslediZaIzmenu(n: Knjiga){
    this.knjigaServis.setElementZaIzmenu(n);
  }

  validirajUloge(uloge: any){                      
    return this.loginServis.validateRoles(uloge);
  }



  //treba da vidim kako bih ovo stavio u angular material, kako da implementiram login i prava pristupa za ovu komponentu, nakon toga sibati dalje komponente
  //angular material za main komponentu, neki meni ili tako nesto asdada




}
