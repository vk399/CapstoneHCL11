import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Customer from '../login/Customer';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8080/api/';  
  
  constructor(private http:HttpClient) { }  
  
  displayCustomer(): Observable<Customer[]>{  
    return this.http.get<Customer[]>(`${this.baseUrl}`+'displayCustomer');  
  }

  deleteCustomer(id:number): Observable<Boolean>{  
    return this.http.delete<Boolean>(`${this.baseUrl}deleteCustomer/${id}`);  
  }

  searchCustomer(id:number): Observable<Customer>{  
    return this.http.get<Customer>(`${this.baseUrl}searchCustomer/${id}`);  
  }
  
  addCustomer(cus:Customer): Observable<Customer>{  
    return this.http.post<Customer>(`${this.baseUrl}addCustomer`,cus);  
  }

  updateCustomer(cus:Customer): Observable<Customer>{  
    return this.http.put<Customer>(`${this.baseUrl}updateCustomer/${cus.id}`,cus);  
  }
  
}
