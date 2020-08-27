import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCebopetComponent } from './create-cebopet.component';

describe('CreateCebopetComponent', () => {
  let component: CreateCebopetComponent;
  let fixture: ComponentFixture<CreateCebopetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCebopetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCebopetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
