import { Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from "@angular/core";


const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
};




@Injectable()
export class AllService {
    private baseUrl = localStorage.getItem('url') + 'campaign/';
    constructor(private http: HttpClient ) { }
    getAll(): Observable<Object> {
        const url = this.baseUrl;
        return this.http.get(url);
    }
}
