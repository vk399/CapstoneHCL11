import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Address from '../login/Address';
import Customer from '../login/Customer';
import { AddressService } from '../Service/address.service';
import { CustomerService } from '../Service/customer.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  customer:Customer = new Customer();
  address :Address=new Address();
  msg: any;
  constructor(private service : CustomerService,private addService:AddressService,
     private router : Router) { }
  ngOnInit(): void {
  }

  signUpData(){
    this.addService.addAddress(this.address).subscribe((data)=>{
     this.address=data;
     console.log(this.address);
    });
    this.customer.address=this.address;
    this.service.addCustomer(this.customer).subscribe((data)=>
      {
        alert("Register Successfully!");
        this.router.navigate(['/loginForm']);
        
      },
      error => {
      this.msg=error.error;
        
      }
      
    )
      }

}
