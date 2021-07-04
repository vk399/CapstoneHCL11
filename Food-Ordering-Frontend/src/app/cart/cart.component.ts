import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { createImportTypeNode } from 'typescript';
import FoodItem from '../fooditems/fooditems';
import { CartService } from '../Service/cart.service';
import { OrdersService } from '../Service/orders.service';
import Orders from './orders';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  order:Array<Orders>=[];
  responseMessage:string="";
  foodItem:FoodItem=new FoodItem();
  cartEmpty:boolean=true;

 
  constructor(private breakpointObserver: BreakpointObserver,private route: ActivatedRoute,private router:Router,
    private service: CartService,private ordersService:OrdersService){ }
 
  ngOnInit(): void {

  
    this.ordersService.displayOrders().subscribe((data)=>{
   this.order=data;
   console.log(this.order.length);
   if(this.order.length==0){
    this.cartEmpty=false;
  }else{
    this.cartEmpty=true;
  }
    });

  
  }

  deleteItem(id:any): void {
    if ((confirm("Are you sure to delete"))) {
      this.ordersService.deleteOrders(id).subscribe((data) => {
        this.ordersService.displayOrders().subscribe((data) => {
          this.order = data;
          this.responseMessage = "Order item deleted Successfully"
        });
      },

        (e) => {
          this.responseMessage = e.error.message;
        });
    }
  }

  updateItem(data1: Orders): void {
    this.ordersService.updateOrders(data1).subscribe((data) => {
      for (let val of this.order) {
        if (val.id == data.id) {
          val = data1;
          console.log(data);
        }
      }
    });
  }

  

 
}
