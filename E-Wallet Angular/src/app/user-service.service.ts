import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {LoginForm} from "./login-form";
import { Userform } from './userform';
import { Addmoneyform } from './addmoneyform';
import { TransactionForm } from './transaction-form';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http:HttpClient) { }

  public doLogin(loginForm:LoginForm){
    return this.http.post("http://localhost:2080/ewallet/login",loginForm,{responseType:'text'});
  }

  public decrypt(token:string){
    let str="";
    for(let i=0;i<token.length;++i){
      str=str+String.fromCharCode(token.charCodeAt(i)-3);
    }
    return str;
  }

  public doLogOut(){
    let utoken=localStorage.getItem("token");
    if(utoken==null) utoken="";
    const httpHeaders=new HttpHeaders();
    httpHeaders.append("userId",utoken);

    return this.http.get("http://localhost:2080/ewallet/logout",{headers:httpHeaders,responseType:'text'});
  }

  public addUser(userform:Userform){
    return this.http.post("http://localhost:2080/ewallet/adduser",userform,{responseType:'text'});
  }

  public addMoney(addMoneyForm:Addmoneyform){

    return this.http.post("http://localhost:2080/ewallet/addmoney",addMoneyForm);

  }

  public transferFund(transactionForm:TransactionForm){
    return this.http.post("http://localhost:2080/ewallet/transact",transactionForm);
  }

  public viewUser(userId:String){
    return this.http.get("http://localhost:2080/ewallet/viewuser/"+userId);
  }
}
