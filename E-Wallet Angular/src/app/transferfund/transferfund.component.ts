import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import { TransactionForm } from '../transaction-form';

@Component({
  selector: 'app-transferfund',
  templateUrl: './transferfund.component.html',
  styleUrls: ['./transferfund.component.css']
})
export class TransferfundComponent implements OnInit {
  msg:string;
  errorMsg:string;
  token:String;
  userId:string;

  transactionForm:TransactionForm=new TransactionForm();
  constructor(private userService:UserServiceService) { }

  ngOnInit() {
    this.token=localStorage.getItem("token");
    this.userId=this.userService.decrypt(this.token.split("-")[0]);
  }

  transferfund(){
    this.transactionForm.fromUserId=this.userId;
    this.userService.transferFund(this.transactionForm).subscribe(data=>{
      this.errorMsg="Unsuccessfull";
      this.msg=undefined;
    },error=>{
      console.log("errpr"+error.error);
      
      this.msg="Successfull";
      this.errorMsg=undefined;
    })
  }

}
