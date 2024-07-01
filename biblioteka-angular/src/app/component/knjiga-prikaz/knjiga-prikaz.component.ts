import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Knjiga } from 'src/app/model/knjiga';
import { KnjigaService } from 'src/app/service/knjiga.service';
import { KorisnikService } from 'src/app/service/korisnik.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-knjiga-prikaz',
  templateUrl: './knjiga-prikaz.component.html',
  styleUrls: ['./knjiga-prikaz.component.css']
})
export class KnjigaPrikazComponent implements OnInit {

  elements: Knjiga[] = [];
  displayedColumns: string[] = ['id', 'cena', 'datumObjave', 'komadaNaStanju', 'naslov', 'autor', 'kategorija', 'akcije'];
  dataSource: any;


  constructor(private knjigaServis: KnjigaService, private router: Router, private loginServis: LoginService, private korisnikService: KorisnikService) {
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
    console.log(element);
    this.knjigaServis.setElementZaIzmenu(element);
    this.router.navigate(["knjiga-forma"]);
  }

  validirajUloge(uloge: any) {
    return this.loginServis.validateRoles(uloge);
  }

  dodaj(){
    this.knjigaServis.elementZaIzmenu = null;
    this.router.navigate(["knjiga-forma"]);
  }



  //za sada ne radi nista samo baci na iznajmljivanje prikaz
  iznajmi(id: number){
    this.korisnikService.dobaviPoKorisnickomImenu(this.loginServis.userr.sub).subscribe(x => {
      //sada kada imam korisnika, imam njegov id, kreiram novo iznajmljivanje preko iznajmljivanje servisa, automatski postavim datum na danasnji i za mesec dana da se vrati
      //id od knjige takodje imam, tako da imam sve samo da kreiram iznajmljivanje
      //kada kreiram iznajmljivanje broj knjiga na stanju se mora smanjiti za 1
      //dohvatim knjigu po id-ju, izmenim je, odnosno samo joj izmenim stanje za -1 i uradim put

    })
    //dodaj u iznajmljivanje + prikaz
    this.router.navigate(["iznajmljivanja-prikaz"]);
  }

}
