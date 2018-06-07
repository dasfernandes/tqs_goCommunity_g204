import { Injectable } from '@angular/core';
import { Observable} from 'rxjs/internal/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
};



@Injectable({
    providedIn: 'root'
})


export class RegisterService {
    private baseUrl = localStorage.getItem('url') + 'user/';
    constructor(private http: HttpClient ) { }
    createUser(name: string, pass: string,  email: string): Observable<Object> {
        const url = this.baseUrl;
        const json = '{"name":"' + name + '","pwhash":"' + pass + '","email":"'  + email + '"}';
        console.log(json);
        return this.http.post(url, json, httpOptions );
    }
}
