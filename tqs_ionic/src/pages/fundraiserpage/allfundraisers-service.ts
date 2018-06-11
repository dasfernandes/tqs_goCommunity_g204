import { Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from "@angular/core";


const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
};




@Injectable()
export class FundService {
    private baseUrl = localStorage.getItem('url') + 'campaign/' + localStorage.getItem('fundId');
    constructor(private http: HttpClient ) { }
    getAll(): Observable<Object> {
        const url = this.baseUrl;
        return this.http.get(url);
    }
}
