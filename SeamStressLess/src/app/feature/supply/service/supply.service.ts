import {inject, Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {API_ENDPOINTS} from "../../../core/constants/api-endpoint";
import {SupplyCategory} from "../models/SupplyCategory";
import {Supply} from "../models/Supply";

@Injectable({
  providedIn: 'root'
})
export class SupplyService {
  private readonly http = inject(HttpClient);
  getSuppliesCategory() {
    return this.http.get<SupplyCategory[]>(`${API_ENDPOINTS.SUPPLY.CATEGORIES.GET_ALL}`)
  }

  getSuppliesByCategory(categoryId: number) {
    return this.http.get<Supply[]>(`${API_ENDPOINTS.SUPPLY.BY_CATEGORY}/${categoryId}`)
  }
}
