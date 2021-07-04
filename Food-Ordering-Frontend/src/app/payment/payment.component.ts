import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdersService } from '../Service/orders.service';
import Payment from './payment';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  payment:Payment=new Payment();
  constructor(private service:OrdersService,private route:Router) { }

  ngOnInit(): void {
  }

  expiryYear:Array<number>=[2021,2022,2023,2024,2025,2026,2027,2028,2029,2030];

  checkOutData(){
    this.service.displayOrders().subscribe((data)=>{
      for(var val of data){
        this.service.deleteOrders(val.id).subscribe();
      }

    })
this.route.navigate(['/successful']);
  }
}
