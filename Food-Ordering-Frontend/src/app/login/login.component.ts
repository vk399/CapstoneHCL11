import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../Service/cart.service';
import { CustomerService } from '../Service/customer.service';
import Customer from './Customer';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  cus:Customer=new Customer();
  id:number=0;
  responseMessage:string="";
  val:number=0;
  e:any;
  fla:number=0;
     
    constructor(private breakpointObserver: BreakpointObserver,private route: ActivatedRoute,private router:Router,
      private service: CustomerService ,private cartService:CartService ) {}
   
    ngOnInit(): void {
    }
   
    loginData():void{
   
  this.service.displayCustomer().subscribe((data)=>{
    this.val=0;
  for(let obj of data){
    if(obj.email==this.cus.email && obj.password==this.cus.password){
      
       this.val=1;
       this.fla=1;
          this.cartService.onLoginSuccess(obj.firstName, this.fla)
          this.router.navigate([`/foodItems/${obj.id}/${obj.firstName}`]);
    }
  }
   
  });
  if(this.val==0){
    this.responseMessage="Entered details are incorrect. Please check once again."
    this.router.navigate([`/loginForm`]);
  }
    }
    flag(arg0: string, flag: any) {
      throw new Error('Method not implemented.');
    }
    
  }
