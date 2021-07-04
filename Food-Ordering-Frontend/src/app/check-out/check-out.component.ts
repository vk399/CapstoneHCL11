import { Component, OnInit } from '@angular/core';
import Address from '../login/Address';
import Customer from '../login/Customer';
import Payment from '../payment/payment';

@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})
export class CheckOutComponent implements OnInit {

  
  ngOnInit(): void {
    
  }

  customer:Customer=new Customer();
  address:Address=new Address();
  payment:Payment=new Payment();
  checkOutData():void{
   
  }
  expiryYear:Array<number>=[2021,2022,2023,2024,2025,2026,2027,2028,2029,2030];

}
