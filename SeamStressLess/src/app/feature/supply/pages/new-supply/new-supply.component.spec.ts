import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewSupplyComponent } from './new-supply.component';

describe('NewSupplyComponent', () => {
  let component: NewSupplyComponent;
  let fixture: ComponentFixture<NewSupplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewSupplyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewSupplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
