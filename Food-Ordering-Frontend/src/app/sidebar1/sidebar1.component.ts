import { Component, Input, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { BehaviorSubject, Observable } from 'rxjs';
import { map, shareReplay, switchMap, window } from 'rxjs/operators';
import { ActivatedRoute,Router } from '@angular/router';
import { RestaurantService } from '../Service/restaurant.service';
import Restaurant from './restaurant';
import { OrdersService } from '../Service/orders.service';
import Orders from '../cart/orders';
import { CartService } from '../Service/cart.service';


@Component({
  selector: 'app-sidebar1',
  templateUrl: './sidebar1.component.html',
  styleUrls: ['./sidebar1.component.css']
})

export class Sidebar1Component implements OnInit {
 
name:string="";
total_price:number=0;
total_quantity:number=0;
res:Array<Restaurant>=[];
order$:Observable<Array<Orders>>=new Observable();
value:number=0;
loginSuccess!:string;
enableProp!:number;


  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver,private route: ActivatedRoute,
    private router:Router,
    private service: RestaurantService,private ordersService:OrdersService,
    private cartService: CartService
    
    ) {
      this.value=route.snapshot.params.id;
      this.name=route.snapshot.params.name;
console.log(this.order$+"dataaaa");
    }

    ngOnInit(): void {
      this.service.displayRestaurant().subscribe((data) => {
        this.res = data
      });


      this.ordersService.displayOrders().subscribe((data)=>{
      this.total_price=0;
      this.total_quantity=0;
   for(let o of data){
    
     this.total_quantity=this.total_quantity+o.quantity;
     this.total_price=this.total_price+(o.quantity*o.price);
   }
      });
   
    }
    passData(data:Restaurant):void{
      this.router.navigate([`/foodItems/${data.resId}`]);
    }
  

    ngDoCheck(){ 
      this.loginSuccess=this.cartService.getLoginSuccess();
      this.enableProp=this.cartService.getSuccessFlag();
      }
      onLogout(){
       location.reload();
       }
 
}
