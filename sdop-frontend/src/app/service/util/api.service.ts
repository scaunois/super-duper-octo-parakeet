import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

/**
 * This class allows to communicate with the backend
 */
@Injectable({
    providedIn: 'root'
})
export class ApiService {
    
    readonly API_URL = 'http://localhost:8080';

    constructor(private http: HttpClient) { }

    get<T>(endpoint: string, options?: any): Observable<any> {
        if (options) {
            return this.http.get<T>(`${this.API_URL}/${endpoint}`, options);
        } else {
            return this.http.get<T>(`${this.API_URL}/${endpoint}`);
        }
    }
}
