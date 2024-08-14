import {Component, inject} from '@angular/core';
import {SideBarComponent} from "../../components/side-bar/side-bar.component";
import {SupplyListComponent} from "../../components/supply-list/supply-list.component";
import {SupplyService} from "../../service/supply.service";
import {Observable} from "rxjs";
import {Supply} from "../../models/Supply";


@Component({
  selector: 'app-list-supplies',
  standalone: true,
  imports: [
    SideBarComponent,
    SupplyListComponent
  ],
  templateUrl: './list-supplies.component.html',
  styleUrl: './list-supplies.component.scss'
})
export class ListSuppliesComponent {
  private readonly supplyService: SupplyService = inject(SupplyService);

  protected supplies$!: Observable<Supply[]>;
  selectedCategory!:number;
  selectCategory($event: number) {
    this.supplies$ = this.supplyService.getSuppliesByCategory($event);
    this.selectedCategory = $event;
  }
}
