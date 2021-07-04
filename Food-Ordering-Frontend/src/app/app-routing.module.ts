import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BodyComponent } from './body/body.component';
import { CartComponent } from './cart/cart.component';
import { ChatbotComponent } from './chatbot/chatbot.component';
import { CheckOutComponent } from './check-out/check-out.component';
import { FooditemsComponent } from './fooditems/fooditems.component';
import { LoginComponent } from './login/login.component';
import { PaymentComponent } from './payment/payment.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: '', redirectTo: 'foodItems', pathMatch: 'full' },  
  { path: 'loginForm', component: LoginComponent },
   { path: 'signUpForm', component: SignupComponent },
   {path: 'foodItems', component:FooditemsComponent},
   {path: 'foodItems/:resId', component:FooditemsComponent},
   {path: 'foodItems/:id/:name', component:FooditemsComponent},
   {path: 'cart', component: CartComponent },
   {path: 'checkOut', component: CheckOutComponent },
   {path:'payment',component:PaymentComponent},
   {path:'successful',component:BodyComponent},
   {path:'chatBot',component:ChatbotComponent},
  
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
