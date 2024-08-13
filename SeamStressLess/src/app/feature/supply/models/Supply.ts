import {SupplyCategory} from "./SupplyCategory";

export interface Supply {
  id: number;
  storeName: string;
  URL: string;
  XPathPrice: string;
  Category: SupplyCategory;
  lastPrice: number;
}

export interface SupplyPost {
  URL: string;
  storeName: string;
  XPathPrice: string;
  categoryId: number;
}
