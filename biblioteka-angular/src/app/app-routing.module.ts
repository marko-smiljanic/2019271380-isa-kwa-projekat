import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { MainComponent } from './component/main/main.component';
import { KnjigaPrikazComponent } from './component/knjiga-prikaz/knjiga-prikaz.component';
import { KnjigaFormaComponent } from './component/knjiga-forma/knjiga-forma.component';
import { AuthGuard } from './guard/auth.guard';
import { RegisterComponent } from './component/register/register.component';
import { IznajmljivanjaPrikazComponent } from './component/iznajmljivanja-prikaz/iznajmljivanja-prikaz.component';

const routes: Routes = [
  {path: "", component: KnjigaPrikazComponent},
  {path: "knjiga-prikaz", component: KnjigaPrikazComponent},
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "knjiga-forma", component: KnjigaFormaComponent, data: {allowedRoles: ["ROLE_ADMIN"], validationMethod: "any"}, canActivate:[AuthGuard]},
  {path: "iznajmljivanja-prikaz", component: IznajmljivanjaPrikazComponent, data: {allowedRoles: ["ROLE_USER"], validationMethod: "any"}, canActivate:[AuthGuard]},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
