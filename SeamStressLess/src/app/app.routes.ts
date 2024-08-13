import {Routes} from '@angular/router';

export const routes: Routes = [
  {path: 'my-supplies', loadComponent: () => import("./feature/supply/pages/list-supplies/list-supplies.component").then((m) => m.ListSuppliesComponent)},
  {path: 'new-supply', loadComponent: () => import("./feature/supply/pages/new-supply/new-supply.component").then((m) => m.NewSupplyComponent)},
  {path: '**', loadComponent: () => import("./feature/home/home.component").then((m) => m.HomeComponent)},
];
