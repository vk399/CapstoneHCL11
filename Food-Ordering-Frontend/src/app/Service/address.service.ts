import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Address from '../login/Address';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private baseUrl = 'http://localhost:8080/api/';  
  
  constructor(private http:HttpClient) { }  

  displayAddress(): Observable<Address[]>{  
    return this.http.get<Address[]>(`${this.baseUrl}`+'displayAddress');  
  }

  deleteAddress(id:number): Observable<Boolean>{  
    return this.http.delete<Boolean>(`${this.baseUrl}deleteAddress/${id}`);  
  }

  searchCart(id:number): Observable<Address>{  
    return this.http.get<Address>(`${this.baseUrl}searchAddress/${id}`);  
  }
  
  addAddress(data:Address): Observable<Address>{  
    return this.http.post<Address>(`${this.baseUrl}addAddress`,data);  
  }

  updateAddress(data:Address): Observable<Address>{  
    return this.http.put<Address>(`${this.baseUrl}updateAddress/${data.id}`,data);  
  }

}
