import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoTruthsAndALieComponent } from './two-truths-and-a-lie.component';

describe('TwoTruthsAndALieComponent', () => {
  let component: TwoTruthsAndALieComponent;
  let fixture: ComponentFixture<TwoTruthsAndALieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwoTruthsAndALieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TwoTruthsAndALieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
