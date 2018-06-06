import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
    constructor() {
        localStorage.setItem('url','http://192.168.1.71:8080/rest_api-1.0-SNAPSHOT/rest/' );
        localStorage.setItem('currentFund', 4 + '');
    }

    ngOnInit() {
    }
}
