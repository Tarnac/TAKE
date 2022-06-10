import { Injectable } from '@angular/core';
import { Movie } from './movie';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private moviesApiUrl = 'http://localhost:8080/movies';

  constructor(private http: HttpClient) { }

  getMovies(): Observable<Movie[]>{
    return this.http.get<Movie[]>(this.moviesApiUrl);
  }

  getMovie(id: number): Observable<Movie>{
    const url = `${this.moviesApiUrl}/${id}`;
    return this.http.get<Movie>(url);
  }
  
}
