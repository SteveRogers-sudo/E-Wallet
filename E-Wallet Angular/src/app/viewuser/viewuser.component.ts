import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-viewuser',
  templateUrl: './viewuser.component.html',
  styleUrls: ['./viewuser.component.css']
})
export class ViewuserComponent implements OnInit {
  token:String;
  userId:string;
  balance;
  constructor(private userService:UserServiceService) { }
  ngOnInit() {
    this.token=localStorage.getItem("token");
    this.userId=this.userService.decrypt(this.token.split("-")[0]);
    this.userService.viewUser(this.userId).subscribe(data=>{
      this.balance=data;
      console.log(data);
    })
  }

}
