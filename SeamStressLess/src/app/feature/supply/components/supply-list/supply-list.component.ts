import {Component, inject, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {SupplyService} from "../../service/supply.service";
import {Observable} from "rxjs";
import {Supply} from "../../models/Supply";
import {SupplyCardComponent} from "../supply-card/supply-card.component";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-supply-list',
  standalone: true,
  imports: [
    SupplyCardComponent,
    AsyncPipe
  ],
  templateUrl: './supply-list.component.html',
  styleUrl: './supply-list.component.scss'
})
export class SupplyListComponent {

  @Input() supplies$!: Observable<Supply[]>;


}
