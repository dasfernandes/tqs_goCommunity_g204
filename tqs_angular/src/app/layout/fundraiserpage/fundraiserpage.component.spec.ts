import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundraiserpageComponent } from './fundraiserpage.component';

describe('FundraiserpageComponent', () => {
  let component: FundraiserpageComponent;
  let fixture: ComponentFixture<FundraiserpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundraiserpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundraiserpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
