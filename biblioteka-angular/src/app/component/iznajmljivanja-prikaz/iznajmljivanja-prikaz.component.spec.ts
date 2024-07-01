import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IznajmljivanjaPrikazComponent } from './iznajmljivanja-prikaz.component';

describe('IznajmljivanjaPrikazComponent', () => {
  let component: IznajmljivanjaPrikazComponent;
  let fixture: ComponentFixture<IznajmljivanjaPrikazComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IznajmljivanjaPrikazComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IznajmljivanjaPrikazComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
