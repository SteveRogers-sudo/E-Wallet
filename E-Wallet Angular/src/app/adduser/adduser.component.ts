import { Component, OnInit } from '@angular/core';
import { Userform } from '../userform';
import { UserServiceService } from '../user-service.service';
import { ConfirmEqualValidatorDirective } from '../confirm-equal-validator.directive';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  userForm:Userform=new Userform();
  msg:string;
  errorMsg:string;
  cpassword:string;

  constructor(private userService:UserServiceService) { }

  ngOnInit() {
  }

  addUser(){
      this.userService.addUser(this.userForm).subscribe(data=>{
        console.log(data);
        this.msg="Successfully Added";
        this.errorMsg=undefined;
        this.userForm=new Userform();
      },error=>{
        console.log(error);
        this.errorMsg="Already registerd with this E-mail or contact Number";
        this.msg=undefined;
      })
      
  }
  getToday(): string {
    return new Date().toISOString().split('T')[0]
 }


}
