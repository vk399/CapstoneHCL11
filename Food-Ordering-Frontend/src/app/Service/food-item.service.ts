import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import FoodItem from '../fooditems/fooditems';

@Injectable({
  providedIn: 'root'
})
export class FoodItemService {
  private baseUrl = 'http://localhost:8080/api/';  
  
  constructor(private http:HttpClient) { }  
  
  displayFoodItem(): Observable<FoodItem[]>{  
    return this.http.get<FoodItem[]>(`${this.baseUrl}`+'displayFoodItem');  
  }

  deleteFoodItem(id:number): Observable<Boolean>{  
    return this.http.delete<Boolean>(`${this.baseUrl}deleteFoodItem/${id}`);  
  }

  searchFoodItem(id:number): Observable<FoodItem>{  
    return this.http.get<FoodItem>(`${this.baseUrl}searchFoodItem/${id}`);  
  }
  
  addFoodItem(item:FoodItem): Observable<FoodItem>{  
    return this.http.post<FoodItem>(`${this.baseUrl}addFoodItem`,item);  
  }

  updateFoodItem(item:FoodItem): Observable<FoodItem>{  
    return this.http.put<FoodItem>(`${this.baseUrl}updateFoodItem/${item.id}`,item);  
  }
}
