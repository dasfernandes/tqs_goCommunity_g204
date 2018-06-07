import { Injectable } from '@angular/core';
import { Observable} from 'rxjs/internal/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
};



@Injectable({
    providedIn: 'root'
})


export class LoginService {
    private baseUrl = localStorage.getItem('url') + 'user/login';
    constructor(private http: HttpClient ) { }
    login(email: string, pass: string): Observable<Object> {
        const url = this.baseUrl;
        const json = '{"email":"' + email + '","pwhash":"' + pass + '"}';
        console.log(json);
        return this.http.post(url, json, httpOptions );
    }
}
