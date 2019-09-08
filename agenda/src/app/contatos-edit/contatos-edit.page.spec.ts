import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContatosEditPage } from './contatos-edit.page';

describe('ContatosEditPage', () => {
  let component: ContatosEditPage;
  let fixture: ComponentFixture<ContatosEditPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContatosEditPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContatosEditPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
