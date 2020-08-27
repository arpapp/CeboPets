import { TestBed } from '@angular/core/testing';

import { CebopetService } from './cebopet.service';

describe('CebopetService', () => {
  let service: CebopetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CebopetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
