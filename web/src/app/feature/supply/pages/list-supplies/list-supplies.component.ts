import {Component, inject, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {SupplyCategory} from "../../models/SupplyCategory";
import {SupplyService} from "../../service/supply.service";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-list-supplies',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './list-supplies.component.html',
  styleUrl: './list-supplies.component.css'
})
export class ListSuppliesComponent implements OnInit {
  private readonly supplyService: SupplyService = inject(SupplyService);
  protected supplyCategories$!: Observable<SupplyCategory[]>;

  ngOnInit() {
    this.supplyCategories$ = this.supplyService.getSuppliesCategory();
  }

}
