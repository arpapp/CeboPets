import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Breed } from '../models/breed';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BreedService {

  constructor(
    private auth: AuthService,
    private http: HttpClient
  ) { }

  private baseUrl = 'http://localhost:8099/';
  private url = this.baseUrl + 'api/cebopets';

  fetchBreed(breedName: string){
    const credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    }
    return this.http.get<Breed>(this.url + '/' + breedName, httpOptions)
    .pipe(
      catchError((err:any) => {
        console.log('Error retrieving breed');
        return throwError('get breed serv error');
      })
    )
  }
}
