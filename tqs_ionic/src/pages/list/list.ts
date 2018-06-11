import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {AllService} from "./allfundraisers-service";
import {Fundraiser} from "./fundraiser";
import {FundraiserpagePage} from "../fundraiserpage/fundraiserpage";

@Component({
  selector: 'page-list',
  templateUrl: 'list.html'
})
export class ListPage {
  selectedItem: any;
  icons: string[];
  items: Array<{title: string, note: string, icon: string}>;
  public fundraisers: Fundraiser[];
  constructor(public navCtrl: NavController, public navParams: NavParams, private allService: AllService) {



    // If we navigated to this page, we will have an item available as a nav param
    this.selectedItem = navParams.get('item');
    this.allService.getAll().subscribe( json => this.update(json));
    // Let's populate this page with some filler content for funzies
    this.icons = ['flask', 'wifi', 'beer', 'football', 'basketball', 'paper-plane',
    'american-football', 'boat', 'bluetooth', 'build'];

    this.items = [];
    for (let i = 1; i < 11; i++) {
      this.items.push({
        title: 'Item ' + i,
        note: 'This is item #' + i,
        icon: this.icons[Math.floor(Math.random() * this.icons.length)]
      });
    }
  }

  itemTapped(event, item) {
    // That's right, we're pushing to ourselves!
    this.navCtrl.push(ListPage, {
      item: item
    });
  }

  update(json: any){
    this.fundraisers = json;
    console.log(this.fundraisers);
  }

  clicked(id: number){
    localStorage.setItem('fundId', id+'');
    this.navCtrl.push(FundraiserpagePage);

  }
}
