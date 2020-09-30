import { Component } from '@angular/core';
import { UserServiceService } from './user-service.service';
import { LoginForm } from './login-form';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EWalletAAngular';

  token:string;
  userid:string;
  password:string;
  userName:string=undefined;

  msg:string;
  flag:boolean=false;
 

  loginForm:LoginForm=new LoginForm();

  constructor(private userService:UserServiceService){}

  ngOnInit() {

    this.token=localStorage.getItem("token");
    this.userid=this.userService.decrypt(this.token.split("-")[0]);
    this.userName=this.userService.decrypt(this.token.split("-")[1]);
    if(this.token!=null){
      // this.userName=this.userService.decrypt(this.token.split("-")[1]);
 
    }
  }

  login(){
    console.log("hey");
    console.log(this.loginForm);
    this.loginForm.userid=this.userid;
    this.loginForm.password=this.password;
    this.userService.doLogin(this.loginForm).subscribe(data=>{
      localStorage.setItem("token",data);
      this.token=data;
      console.log(data);
      this.userName=this.userService.decrypt(this.token.split("-")[1]);
    },error=>{
      console.log(error.error);
      this.msg="You are not authenticated and authorized, Please Login";
    })
  }

  logout(){
    this.userService.doLogOut().subscribe(data=>{
      localStorage.removeItem("token");
      this.token=null;
      this.msg=undefined;
      alert("You are logged out");
    })
  }

  toggle(){
    this.flag=!this.flag;
  }

 
}
