import {Component} from '@angular/core';
import {SideBarComponent} from "../../components/side-bar/side-bar.component";
import {SupplyListComponent} from "../../components/supply-list/supply-list.component";


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

}
