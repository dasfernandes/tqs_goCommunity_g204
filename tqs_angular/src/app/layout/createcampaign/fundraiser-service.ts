import { Injectable } from '@angular/core';
import { Observable} from 'rxjs/internal/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
};



@Injectable({
    providedIn: 'root'
})


export class CampaignService {
    private baseUrl = localStorage.getItem('url') + 'campaign/';
    constructor(private http: HttpClient ) { }
    createCampaign(title: string, description: string, image: string, goal: number ): Observable<Object> {
        const url = this.baseUrl;
        const json = '{"title":"' + title + '","description":"' + description + '","user_id":"' + localStorage.getItem('id') + '","goal":' + goal + ',"image":"' + image + '"}';
        console.log(json);
        return this.http.post(url, json, httpOptions );
    }
}
