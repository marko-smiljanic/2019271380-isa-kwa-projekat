import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KnjigaPrikazComponent } from './knjiga-prikaz.component';

describe('KnjigaPrikazComponent', () => {
  let component: KnjigaPrikazComponent;
  let fixture: ComponentFixture<KnjigaPrikazComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KnjigaPrikazComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KnjigaPrikazComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
