import {Component, inject, OnInit} from '@angular/core';
import {AsyncPipe} from "@angular/common";
import {MatCardModule} from "@angular/material/card";
import {SupplyService} from "../../service/supply.service";
import {Observable} from "rxjs";
import {SupplyCategory} from "../../models/SupplyCategory";

@Component({
  selector: 'app-side-bar',
  standalone: true,
  imports: [
    AsyncPipe,
    MatCardModule,
  ],
  templateUrl: './side-bar.component.html',
  styleUrl: './side-bar.component.scss'
})
export class SideBarComponent implements OnInit {
  private readonly supplyService: SupplyService = inject(SupplyService);

  protected supplyCategories$!: Observable<SupplyCategory[]>;

  ngOnInit() {
    this.supplyCategories$ = this.supplyService.getSuppliesCategory();
  };

}
