import {Component, EventEmitter, inject, OnInit, Output} from '@angular/core';
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
  @Output() selectedCategory = new EventEmitter<number>();

  protected selectedCategoryId: number | null = null;

  ngOnInit() {
    this.supplyCategories$ = this.supplyService.getSuppliesCategory();
  }

  selectCategory(categoryId: number) {
    this.selectedCategoryId = categoryId;
    this.selectedCategory.emit(categoryId);
    console.log('Selected category:', categoryId);
  }
}
