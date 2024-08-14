import {Component, inject, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {SupplyService} from "../../service/supply.service";
import {Observable} from "rxjs";
import {Supply} from "../../models/Supply";
import {SupplyCardComponent} from "../supply-card/supply-card.component";
import {AsyncPipe} from "@angular/common";
import {MatButton} from "@angular/material/button";
import {Router, RouterLink} from "@angular/router";

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
  private readonly router: Router = inject(Router);

  @Input() supplies$!: Observable<Supply[]>;
  @Input() selectedCategory!: number;

  navigateToNewSupply() {
    this.router.navigate(['/new-supply/'+this.selectedCategory]);
  }


}
