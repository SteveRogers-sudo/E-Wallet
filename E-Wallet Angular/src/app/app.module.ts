import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { AdduserComponent } from './adduser/adduser.component';
import { ConfirmEqualValidatorDirective } from './confirm-equal-validator.directive';
import { HomeComponent } from './home/home.component';
import { AddmoneyComponent } from './addmoney/addmoney.component';
import { TransferfundComponent } from './transferfund/transferfund.component';
import { ViewuserComponent } from './viewuser/viewuser.component';

const routes:Routes=[
  {path:'home',component:HomeComponent},
  {path:'adduser',component:AdduserComponent},
  {path:'addmoney',component:AddmoneyComponent},
  {path:'transferfund',component:TransferfundComponent},
  {path:'viewbalance',component:ViewuserComponent}
]


@NgModule({
  declarations: [
    AppComponent,
    AdduserComponent,
    ConfirmEqualValidatorDirective,
    HomeComponent,
    AddmoneyComponent,
    TransferfundComponent,
    ViewuserComponent
  ],
  imports: [
    BrowserModule,FormsModule,HttpClientModule,RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
