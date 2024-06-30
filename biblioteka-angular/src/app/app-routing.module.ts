import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { MainComponent } from './component/main/main.component';
import { KnjigaPrikazComponent } from './component/knjiga-prikaz/knjiga-prikaz.component';

const routes: Routes = [
  {path: "", component: KnjigaPrikazComponent},
  {path: "login", component: LoginComponent}
  // {path: "knjiga-prikaz", component: KnjigaPrikazComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
