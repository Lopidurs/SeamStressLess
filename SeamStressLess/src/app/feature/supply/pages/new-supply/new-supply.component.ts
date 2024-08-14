import {Component, inject, OnInit} from '@angular/core';
import { MatFormFieldModule} from "@angular/material/form-field";
import {MatButton} from "@angular/material/button";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatInput} from "@angular/material/input";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Observable} from "rxjs";
import {SupplyCategory} from "../../models/SupplyCategory";
import {SupplyService} from "../../service/supply.service";
import {AsyncPipe} from "@angular/common";
import {MatCardModule} from "@angular/material/card";
import {ActivatedRoute, Route, Router} from "@angular/router";

@Component({
  selector: 'app-new-supply',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatButton,
    MatSelect,
    MatOption,
    MatInput,
    ReactiveFormsModule,
    AsyncPipe,
    MatCardModule
  ],
  templateUrl: './new-supply.component.html',
  styleUrl: './new-supply.component.scss'
})

export class NewSupplyComponent implements OnInit {
  private readonly route: ActivatedRoute = inject(ActivatedRoute);
  private readonly supplyService: SupplyService = inject(SupplyService);
  private readonly fb = inject(FormBuilder);
  private readonly router = inject(Router);

  category$!: Observable<SupplyCategory>;
  supplyForm!: FormGroup;
  ngOnInit() {
    const categoryId = this.route.snapshot.params['id'];
    this.supplyForm = this.fb.group({
      URL: ['', [Validators.required, Validators.pattern('https?://.+')]],
      storeName: ['', Validators.required],
      xPathPrice: ['', Validators.required],
      categoryId: [categoryId, Validators.required],
    });
    this.category$ = this.supplyService.getSupplyCategoryById(categoryId);
  }

  onSubmit() {
    if (this.supplyForm.valid) {
      this.supplyService.postSupply(this.supplyForm.value).subscribe();
      this.router.navigate(['/my-supplies']);
    }
  }
}
