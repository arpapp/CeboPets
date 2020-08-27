import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cebopet } from '../models/cebopet';
import { AuthService } from './auth.service';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CebopetService {

  private baseUrl = 'http://localhost:8099/';
  private url = this.baseUrl + 'api/cebopets';

  constructor(
    private http: HttpClient,
    private auth: AuthService) { }

  createCebopet(cebopet:Cebopet){
    const credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    }

    return this.http.post<Cebopet>(this.url, cebopet, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log('Error in cebopet service create');
          return throwError('create cebopet error');
        })
      )

  }
}
