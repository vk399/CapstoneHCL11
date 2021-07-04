import { Component, OnInit } from '@angular/core';
import FoodItems from './fooditems';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodItemService } from '../Service/food-item.service';
import { OrdersService } from '../Service/orders.service';
import Orders from '../cart/orders';
import Restaurant from '../sidebar1/restaurant';
import Customer from '../login/Customer';
import { CustomerService } from '../Service/customer.service';
import FoodItem from './fooditems';

@Component({
  selector: 'app-fooditems',
  templateUrl: './fooditems.component.html',
  styleUrls: ['./fooditems.component.css']
})
export class FooditemsComponent implements OnInit {

  title="Search function";
  searchText:any;
resId:number=0;
value:number=1;
count:number=1;
name:string="";
restaurant:Restaurant=new Restaurant();
items:Array<FoodItem>=[];
arrItems:Array<FoodItem>=[];
order:Orders=new Orders();
cust:Customer=new Customer();


  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

    constructor(private breakpointObserver: BreakpointObserver,private route: ActivatedRoute,private router:Router,
      private service: FoodItemService,private ordersService:OrdersService,private cusService:CustomerService) {
        this.resId=this.route.snapshot.params.resId;
        this.value=this.route.snapshot.params.id;
        this.name=this.route.snapshot.params.name;    
        
      }

  ngOnInit(): void {
   
    this.arrItems=[];
    if(this.resId>0){
    this.service.displayFoodItem().subscribe((data) => {
      this.items=[];
      for(let obj of data)
      {
        if(obj.restaurant.resId==this.resId){
          this.items.push(obj);
        }
      }
    });
  }else{
    this.service.displayFoodItem().subscribe((data)=>
    {
      this.items=data;
    });
  }
}


sendToCart(data:FoodItem):void{
  if(this.name==null){
    if(confirm("Please login first to add items in cart")){
    this.router.navigate([`/loginForm`]);
    console.log("Not signed in");
    }
  }else{
    this.order.id=this.count++;
    this.order.quantity=1;
    this.order.price=(this.order.quantity)*(data.price);
    this.order.foodItem=data;

    
  this.cusService.searchCustomer(this.value).subscribe((data)=>{
    this.cust=data;
    });
    this.order.customer=this.cust;
  
  this.ordersService.addOrders(this.order).subscribe((data1)=>{
    this.order=data1;
  }
  );
  }
}
}
