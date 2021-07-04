import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Cart from '../cart/Cart';


@Injectable({
  providedIn: 'root'
})
export class CartService {

  private baseUrl = 'http://localhost:8080/api/';  
  loginSuccessUser!:string;
  flag!:number;
  
  constructor(private http:HttpClient) { }  
  
  displayCart(): Observable<Cart[]>{  
    return this.http.get<Cart[]>(`${this.baseUrl}`+'displayCart');  
  }

  deleteCart(id:number): Observable<Boolean>{  
    return this.http.delete<Boolean>(`${this.baseUrl}deleteCart/${id}`);  
  }

  searchCart(id:number): Observable<Cart>{  
    return this.http.get<Cart>(`${this.baseUrl}searchCart/${id}`);  
  }
  
  addCart(cart:Cart): Observable<Cart>{  
    return this.http.post<Cart>(`${this.baseUrl}addCart`,cart);  
  }

  updateCart(cart:Cart): Observable<Cart>{  
    return this.http.put<Cart>(`${this.baseUrl}updateCustomer/${cart.id}`,cart);  
  }

  public onLoginSuccess(data:string,flag:number){
    this.flag=flag;
    this.loginSuccessUser=data;
  }
 
  public getLoginSuccess():string{
    return this.loginSuccessUser;
  }
 
  public getSuccessFlag():number{
    return this.flag;
  }

}
