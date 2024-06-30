import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource, MatTableModule} from '@angular/material/table';
import { Router } from '@angular/router';
import { Knjiga } from 'src/app/model/knjiga';
import { KnjigaService } from 'src/app/service/knjiga.service';
import { LoginService } from 'src/app/service/login.service';
import {LiveAnnouncer} from '@angular/cdk/a11y';

@Component({
  selector: 'app-knjiga-prikaz',
  templateUrl: './knjiga-prikaz.component.html',
  styleUrls: ['./knjiga-prikaz.component.css']
})
export class KnjigaPrikazComponent implements OnInit {

  elements: Knjiga[] = [];
  displayedColumns: string[] = ['id', 'cena', 'datumObjave', 'komadaNaStanju', 'naslov', 'autor', 'kategorija', 'akcije'];
  dataSource: any;


  constructor(private knjigaServis: KnjigaService, private router: Router, private loginServis: LoginService) {
    this.knjigaServis.getAll().subscribe(x => {
      this.elements = x;
      this.dataSource = this.elements
    })
  }


  ngOnInit(): void {
  }

  izbrisi(id: number) {
    this.knjigaServis.delete(id).subscribe(_ => {
      this.knjigaServis.getAll().subscribe(x => {
        this.elements = x;
        this.dataSource.data = this.elements; // Update dataSource after delete
      })
    })
  }

  proslediZaIzmenu(element: Knjiga) {
    this.knjigaServis.setElementZaIzmenu(element);
  }

  validirajUloge(uloge: any) {
    return this.loginServis.validateRoles(uloge);
  }


//uradio sam angular material i bootstrap prikaze za knjigu i main komponentu, sada treba da implementiram ostale komponente (prikaze i forme) i da popunim bazu sa nekim podacima

}
