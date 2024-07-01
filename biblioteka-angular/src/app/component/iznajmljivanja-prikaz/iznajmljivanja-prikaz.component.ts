import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Iznajmljivanje } from 'src/app/model/iznajmljivanje';
import { Korisnik } from 'src/app/model/korisnik';
import { IznajmljivanjeService } from 'src/app/service/iznajmljivanje.service';
import { KnjigaService } from 'src/app/service/knjiga.service';
import { KorisnikService } from 'src/app/service/korisnik.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-iznajmljivanja-prikaz',
  templateUrl: './iznajmljivanja-prikaz.component.html',
  styleUrls: ['./iznajmljivanja-prikaz.component.css']
})
export class IznajmljivanjaPrikazComponent implements OnInit {

  elements: Iznajmljivanje[] = [];
  displayedColumns: string[] = ['id', 'datumIznajmljivanja', 'datumVracanja', 'korisnik', 'knjiga', 'akcije'];
  dataSource: any;
  ulogovaniKorisnik: Korisnik | any;


  constructor(private korisnikService: KorisnikService, private router: Router, private loginServis: LoginService, private iznajmljivanjeServis: IznajmljivanjeService) {

    //prvo dohvatam ulogovanog korisnika, ceo objekat (sa id-jem), onda njegov id koristim za dohvatanje samo njegovih iznajmljivanja
    this.korisnikService.dobaviPoKorisnickomImenu(this.loginServis.userr.sub).subscribe(x => {
        
      this.iznajmljivanjeServis.dobaviPoKorisniku(x.id).subscribe(iznajmljivanja => {
          this.elements = iznajmljivanja;
          this.dataSource = this.elements
        })
    })

  }


  ngOnInit(): void {
  }

  izbrisi(id: number) {
    this.iznajmljivanjeServis.delete(id).subscribe(_ => {
      this.iznajmljivanjeServis.getAll().subscribe(x => {
        this.elements = x;
        this.dataSource.data = this.elements; // Update dataSource after delete
      })
    })
  }

  // proslediZaIzmenu(element: Knjiga) {
  //   console.log(element);
  //   this.knjigaServis.setElementZaIzmenu(element);
  //   this.router.navigate(["knjiga-forma"]);
  // }

  validirajUloge(uloge: any) {
    return this.loginServis.validateRoles(uloge);
  }

  // dodaj(){
  //   this.knjigaServis.elementZaIzmenu = null;
  //   this.router.navigate(["knjiga-forma"]);
  // }


  //zavrsio sam da se prikazu lepo iznajmljivanja, ostaje jos da ovde implementiram dugme vrati knjigu koja nece biti nista drugo nego obicno brisanje
  //kada neko klikne na vrati knjigu ja dohvatim knjigu po id-ju (u iznajmljivanju imam objekat knjiga), nakon toga 
  //broj knjiga na stanju se mora povecati onda za jedan i obrisem to iznajmljivanje
  //ne treba mi izmena i dodavanje novog (to se radi u knjiga prikaz na dugme iznajmi)


}
