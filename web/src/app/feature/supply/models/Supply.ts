import {SupplyCategory} from "./SupplyCategory";

export interface Supply {
  id: number;
  URL: string;
  XPathPrice: string;
  Category: SupplyCategory;
}
