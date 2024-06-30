import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Autor } from 'src/app/model/autor';
import { Kategorija } from 'src/app/model/kategorija';
import { Knjiga } from 'src/app/model/knjiga';
import { AutorService } from 'src/app/service/autor.service';
import { KategorijaService } from 'src/app/service/kategorija.service';
import { KnjigaService } from 'src/app/service/knjiga.service';

@Component({
  selector: 'app-knjiga-forma',
  templateUrl: './knjiga-forma.component.html',
  styleUrls: ['./knjiga-forma.component.css']
})
export class KnjigaFormaComponent implements OnInit {

  elementi: Knjiga[] = [];
  autori: Autor[] = [];
  kategorije: Kategorija[] = [];

  //@Input()                                            
  set elementZaIzmenu(n: Knjiga) {         //observer nad elementom za izmenu, tj. nad n, njegovo setovanje se radi u konstruktoru
    this.setujZaIzmenu(n); 
    console.log(n);
  }


  forma : FormGroup = new FormGroup({                                             
    "id" : new FormControl(null),                                                  
    "cena" : new FormControl(null, [Validators.required]),  
    "datumObjave" : new FormControl(null, [Validators.required]),                            
    "komadaNaStanju" : new FormControl(null, [Validators.required]),
    "naslov" : new FormControl(null, [Validators.required]),
    "autor" : new FormControl(null, [Validators.required]),
    "kategorija" : new FormControl(null, [Validators.required])
  }); 

  constructor(private knjigaServis : KnjigaService,  private autorServis: AutorService, private kategorijaServis: KategorijaService,private router: Router) {
    this.elementZaIzmenu = this.knjigaServis.elementZaIzmenu;

    this.autorServis.getAll().subscribe(x=> {
      this.autori = x;
    });

    this.kategorijaServis.getAll().subscribe(x=> {
      this.kategorije = x;
    });

  }

  ngOnInit(): void {
    this.resetujElementZaIzmenuUServisu();
  }

  naSubmit(){
    if(this.forma.valid) {
      if(this.forma.value["id"] == null){

        // let formData = {...this.forma.value};
        // // delete formData.id;
        // formData["datumObjave"] = formData["datumObjave"] = formatDate(new Date(formData["datumObjave"]), 'yyyy-MM-dd', 'en-US');
        // console.log(formData);

        //moram da formatiram datum zato sto zbog razlike u vremenskoj zoni server kada obradi prosledjeni datum posle vrati na klijenta za dan manje
        this.forma.value.datumObjave = formatDate(new Date(this.forma.value.datumObjave), 'yyyy-MM-dd', 'en-US');

        this.knjigaServis.create(this.forma.value).subscribe(_ =>{
          this.knjigaServis.getAll().subscribe(x =>{
            this.elementi = x;

            this.resetujElementZaIzmenuUServisu();
            this.router.navigate(["knjiga-prikaz"]);
          });
      });

      }else{    
        this.setujZaIzmenu(this.elementZaIzmenu);
        this.knjigaServis.update(this.forma.value["id"], this.forma.value).subscribe(_ =>{
          this.knjigaServis.getAll().subscribe(x =>{
            this.elementi = x;
          });
          this.forma.value["id"] = null;                                                              
          this.forma.reset();                                                 
      
          this.resetujElementZaIzmenuUServisu();
          this.router.navigate(["knjiga-prikaz"]);
      });
      }
    }
  }

  setujZaIzmenu(n : Knjiga){   
    this.forma.patchValue(n);
  }

  resetujElementZaIzmenuUServisu(){
    this.knjigaServis.elementZaIzmenu = null;
  }


}
