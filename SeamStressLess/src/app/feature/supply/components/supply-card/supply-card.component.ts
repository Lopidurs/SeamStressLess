import {Component, Input} from '@angular/core';
import {Supply} from "../../models/Supply";
import {MatCardModule} from "@angular/material/card";

@Component({
  selector: 'app-supply-card',
  standalone: true,
  imports: [
    MatCardModule
  ],
  templateUrl: './supply-card.component.html',
  styleUrl: './supply-card.component.scss'
})
export class SupplyCardComponent {
  @Input() supply!: Supply;

}
