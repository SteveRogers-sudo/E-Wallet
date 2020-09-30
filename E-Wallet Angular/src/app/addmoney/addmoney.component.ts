import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import { Addmoneyform } from '../addmoneyform';

@Component({
  selector: 'app-addmoney',
  templateUrl: './addmoney.component.html',
  styleUrls: ['./addmoney.component.css']
})
export class AddmoneyComponent implements OnInit {
  msg:string;
  errorMsg:string;
  userId:string;
  addMoneyForm:Addmoneyform=new Addmoneyform
  token:String;

  constructor(private userService:UserServiceService) { }

  ngOnInit() {
    this.token=localStorage.getItem("token");
    this.userId=this.userService.decrypt(this.token.split("-")[0]);
  }

  addMoney(){
    this.addMoneyForm.userid=this.userId;

    this.userService.addMoney(this.addMoneyForm).subscribe(data=>{
      this.msg="Money Added";
      this.errorMsg=undefined;
      this.addMoneyForm=new Addmoneyform();
    },error=>{
      console.log(error);
      this.errorMsg="Not Added";
      this.msg=undefined;
    })

    
  }

}
