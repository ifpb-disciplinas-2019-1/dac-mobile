import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContatosListPage } from './contatos-list.page';

describe('ContatosListPage', () => {
  let component: ContatosListPage;
  let fixture: ComponentFixture<ContatosListPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContatosListPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContatosListPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
