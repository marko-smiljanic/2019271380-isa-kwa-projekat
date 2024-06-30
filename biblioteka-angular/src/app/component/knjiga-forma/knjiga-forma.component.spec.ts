import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KnjigaFormaComponent } from './knjiga-forma.component';

describe('KnjigaFormaComponent', () => {
  let component: KnjigaFormaComponent;
  let fixture: ComponentFixture<KnjigaFormaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KnjigaFormaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KnjigaFormaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
