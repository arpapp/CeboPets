import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BreedService {

  constructor() { }

  private baseUrl = 'http://localhost:8099/';
  private url = this.baseUrl + 'api/cebopets';

  
}
