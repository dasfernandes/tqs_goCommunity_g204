import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../router.animations';
import {LoginService} from './register-service';
import {User} from './user';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
    constructor(public router: Router, private login1: LoginService) {
        localStorage.setItem('isLoggedin', 'true');
    }
    public user: User;
    public email: string;
    public pass: string;
    ngOnInit() {}

    onLoggedin() {
        this.login1.login(this.email, this.pass).subscribe( json => this.update(json));
    }
    update(json: any) {
        this.user = json;
        if (!(this.user === null)) {
            localStorage.setItem('isLoggedin', 'true');
            localStorage.setItem('login', 'true');
            localStorage.setItem('name', this.user.name);
            localStorage.setItem('id', ''+ this.user.id);
            this.router.navigate(['allfundraisers']);
        } else {
            alert('Wrong username/password');
        }
    }


}
