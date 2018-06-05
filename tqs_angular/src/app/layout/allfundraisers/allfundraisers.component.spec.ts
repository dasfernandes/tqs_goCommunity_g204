import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllfundraisersComponent } from './allfundraisers.component';

describe('AllfundraisersComponent', () => {
  let component: AllfundraisersComponent;
  let fixture: ComponentFixture<AllfundraisersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllfundraisersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllfundraisersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
