import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimeiroAutorComponent } from './primeiro-autor.component';

describe('PrimeiroAutorComponent', () => {
  let component: PrimeiroAutorComponent;
  let fixture: ComponentFixture<PrimeiroAutorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrimeiroAutorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrimeiroAutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
