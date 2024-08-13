import {Component, EventEmitter, inject, OnInit, Output} from '@angular/core';
import {AsyncPipe} from "@angular/common";
import {MatCardModule} from "@angular/material/card";
import {SupplyService} from "../../service/supply.service";
import {Observable} from "rxjs";
import {SupplyCategory} from "../../models/SupplyCategory";
import {MatIcon} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule} from "@angular/forms";
import {MatInput} from "@angular/material/input";
import {MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-side-bar',
  standalone: true,
  imports: [
    AsyncPipe,
    MatCardModule,
    MatIcon,
    MatFormFieldModule,
    FormsModule,
    MatInput,
    MatIconButton,
  ],
  templateUrl: './side-bar.component.html',
  styleUrl: './side-bar.component.scss'
})
export class SideBarComponent implements OnInit {
  private readonly supplyService: SupplyService = inject(SupplyService);

  protected supplyCategories$!: Observable<SupplyCategory[]>;
  @Output() selectedCategory = new EventEmitter<number>();

  protected selectedCategoryId: number | null = null;
  protected isAdding: boolean = false;
  protected newCategoryName: string = '';

  ngOnInit() {
    this.supplyCategories$ = this.supplyService.getSuppliesCategory();
  }

  selectCategory(categoryId: number) {
    this.selectedCategoryId = categoryId;
    this.selectedCategory.emit(categoryId);
  }

  startAddingCategory() {
    this.isAdding = true;
  }

  addNewCategory() {
    if (this.newCategoryName.trim()) {
      this.supplyService.postSupplyCategory(this.newCategoryName.trim()).subscribe({
        next: (newCategory) => {
          console.log('Nouvelle catégorie ajoutée:', newCategory);
          this.supplyCategories$ = this.supplyService.getSuppliesCategory(); // Rafraîchir la liste
        },
        error: (error) => console.error('Erreur lors de l\'ajout de la catégorie:', error)
      });
    }
    this.isAdding = false;
    this.newCategoryName = '';
  }
}
