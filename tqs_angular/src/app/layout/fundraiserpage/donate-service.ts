import { Injectable } from '@angular/core';
import { Observable} from 'rxjs/internal/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
};



@Injectable({
    providedIn: 'root'
})


export class DonateService {
    private baseUrl = localStorage.getItem('url') + 'donation/';
    constructor(private http: HttpClient ) { }
    donate(value: number, campanha: number): Observable<Object> {
        const url = this.baseUrl;
        const json = '{"user_id":"' + localStorage.getItem('id') + '","campanha_id":"' + campanha  + '","ammount":' + value + '}';
        console.log(json);
        return this.http.post(url, json, httpOptions );
    }
}
