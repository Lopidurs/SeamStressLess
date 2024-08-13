import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplyCardComponent } from './supply-card.component';

describe('SupplyCardComponent', () => {
  let component: SupplyCardComponent;
  let fixture: ComponentFixture<SupplyCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SupplyCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SupplyCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
