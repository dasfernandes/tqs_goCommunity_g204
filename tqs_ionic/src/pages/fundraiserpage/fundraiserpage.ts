import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {Fundraiser} from "./fundraiser";
import {FundService} from "./allfundraisers-service";

/**
 * Generated class for the FundraiserpagePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-fundraiserpage',
  templateUrl: 'fundraiserpage.html',
})
export class FundraiserpagePage {

  public FundRaiser= [];
  public id: string;
  constructor(public navCtrl: NavController, public navParams: NavParams, private fundService: FundService) {
    this.fundService.getAll().subscribe(json => this.update(json));
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad FundraiserpagePage');
  }

  update(json: any){
    console.log('ola');
    console.log(json);
    this.FundRaiser[0] = json;
    console.log(this.FundRaiser);

  }

}
