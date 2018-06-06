import { Injectable } from '@angular/core';
import { Observable} from 'rxjs/internal/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
};



@Injectable({
    providedIn: 'root'
})


export class AllService {
    private baseUrl = localStorage.getItem('url') + 'campaign/';
    constructor(private http: HttpClient ) { }
    getAll(): Observable<Object> {
        const url = this.baseUrl;
        return this.http.get(url);
    }
}
