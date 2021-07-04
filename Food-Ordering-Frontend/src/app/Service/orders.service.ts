import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Orders from '../cart/orders';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  private baseUrl = 'http://localhost:8080/api/';  
  
  constructor(private http:HttpClient) { }  
  
  displayOrders(): Observable<Orders[]>{  
    return this.http.get<Orders[]>(`${this.baseUrl}`+'displayOrders');  
  }

  deleteOrders(id:number): Observable<Boolean>{  
    return this.http.delete<Boolean>(`${this.baseUrl}deleteOrders/${id}`);  
  }

  searchOrders(id:number): Observable<Orders>{  
    return this.http.get<Orders>(`${this.baseUrl}searchOrders/${id}`);  
  }
  
  addOrders(order:Orders): Observable<Orders>{  
    return this.http.post<Orders>(`${this.baseUrl}addOrders`,order);  
  }

  updateOrders(order:Orders): Observable<Orders>{  
    return this.http.put<Orders>(`${this.baseUrl}updateOrders/${order.id}`,order);  
  }
}
