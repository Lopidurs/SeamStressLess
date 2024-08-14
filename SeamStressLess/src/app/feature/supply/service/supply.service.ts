import {inject, Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {API_ENDPOINTS} from "../../../core/constants/api-endpoint";
import {SupplyCategory} from "../models/SupplyCategory";
import {Supply, SupplyPost} from "../models/Supply";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SupplyService {
  private readonly http = inject(HttpClient);
  getSuppliesCategory() {
    return this.http.get<SupplyCategory[]>(`${API_ENDPOINTS.SUPPLY.CATEGORIES.GET_ALL}`)
  }

  getSupplyCategoryById(categoryId: number) {
    return this.http.get<SupplyCategory>(`${API_ENDPOINTS.SUPPLY.CATEGORIES.GET_BY_ID}/${categoryId}`)
  }

  getSuppliesByCategory(categoryId: number) {
    return this.http.get<Supply[]>(`${API_ENDPOINTS.SUPPLY.BY_CATEGORY}/${categoryId}`)
  }

  postSupplyCategory(supplyCategoryName: string): Observable<SupplyCategory> {
    const supplyCategory: { name: string } = { name: supplyCategoryName };
    return this.http.post<SupplyCategory>(`${API_ENDPOINTS.SUPPLY.CATEGORIES.POST}`, supplyCategory);
  }

  postSupply(supply: SupplyPost): Observable<Supply> {
    return this.http.post<Supply>(`${API_ENDPOINTS.SUPPLY.POST}`, supply);
  }
}
