import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MainComponent } from './component/main/main.component';
import { LoginComponent } from './component/login/login.component';

import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { KnjigaPrikazComponent } from './component/knjiga-prikaz/knjiga-prikaz.component';


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    LoginComponent,
    KnjigaPrikazComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,


    ReactiveFormsModule,
    HttpClientModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    BrowserAnimationsModule
    
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
