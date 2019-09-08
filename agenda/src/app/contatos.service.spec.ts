import { TestBed } from '@angular/core/testing';

import { ContatosService } from './contatos.service';

describe('ContatosService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ContatosService = TestBed.get(ContatosService);
    expect(service).toBeTruthy();
  });
});
