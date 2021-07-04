import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Restaurant from '../sidebar1/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private baseUrl = 'http://localhost:8080/api/';  
  
  constructor(private http:HttpClient) { }  
  
  displayRestaurant(): Observable<Restaurant[]>{  
    return this.http.get<Restaurant[]>(`${this.baseUrl}`+'displayRestaurant');  
  }

  deleteRestaurant(id:number): Observable<Boolean>{  
    return this.http.delete<Boolean>(`${this.baseUrl}deleteRestaurant/${id}`);  
  }

  searchRestaurant(id:number): Observable<Restaurant>{  
    return this.http.get<Restaurant>(`${this.baseUrl}searchRestaurant/${id}`);  
  }
  
  addRestaurant(res:Restaurant): Observable<Restaurant>{  
    return this.http.post<Restaurant>(`${this.baseUrl}addRestaurant`,res);  
  }

  updateRestaurant(res:Restaurant): Observable<Restaurant>{  
    return this.http.put<Restaurant>(`${this.baseUrl}updateRestaurant/${res.resId}`,res);  
  }
}
