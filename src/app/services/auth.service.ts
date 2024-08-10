import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = 'http://localhost:8090/auth/login';

  constructor(private http: HttpClient) { }

  login(credentials: { login: string, password: string }): Observable<any> {
    return this.http.post<any>(this.loginUrl, credentials)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // Erreur côté client ou réseau
      console.error('Une erreur est survenue:', error.error.message);
    } else {
      // Erreur côté backend
      console.error(
        `Backend a renvoyé le code ${error.status}, ` +
        `le corps de la réponse était: ${error.error}`);
    }
    return throwError(
      'Quelque chose a mal tourné; veuillez réessayer plus tard.');
  }
  
}