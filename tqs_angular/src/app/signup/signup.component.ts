import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../router.animations';
import {RegisterService} from './register-service';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.scss'],
    animations: [routerTransition()]
})
export class SignupComponent implements OnInit {
    public name: string;
    public pass: string;
    public email: string;
    constructor(private sign: RegisterService) {}

    ngOnInit() {}
    click(name: string, pass: string, email: string){
        this.sign.createUser(name, pass, email).subscribe( json => alert('Success'));
    }
}
