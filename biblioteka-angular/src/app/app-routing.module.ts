import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { MainComponent } from './component/main/main.component';
import { KnjigaPrikazComponent } from './component/knjiga-prikaz/knjiga-prikaz.component';
import { KnjigaFormaComponent } from './component/knjiga-forma/knjiga-forma.component';
import { AuthGuard } from './guard/auth.guard';
import { RegisterComponent } from './component/register/register.component';

const routes: Routes = [
  {path: "", component: KnjigaPrikazComponent},
  {path: "knjiga-prikaz", component: KnjigaPrikazComponent},
  {path: "login", component: LoginComponent},
  {path: "knjiga-forma", component: KnjigaFormaComponent, data: {allowedRoles: ["ROLE_ADMIN"], validationMethod: "any"}, canActivate:[AuthGuard]},
  {path: "register", component: RegisterComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
