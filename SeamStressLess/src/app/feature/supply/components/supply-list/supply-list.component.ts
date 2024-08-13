import {Component, inject, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {SupplyService} from "../../service/supply.service";
import {Observable} from "rxjs";
import {Supply} from "../../models/Supply";
import {SupplyCardComponent} from "../supply-card/supply-card.component";
import {AsyncPipe} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-supply-list',
  standalone: true,
  imports: [
    SupplyCardComponent,
    AsyncPipe,
    MatButton,
    RouterLink
  ],
  templateUrl: './supply-list.component.html',
  styleUrl: './supply-list.component.scss'
})
export class SupplyListComponent {

  @Input() supplies$!: Observable<Supply[]>;


}
