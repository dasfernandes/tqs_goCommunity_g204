import { Component, OnInit } from '@angular/core';
import {AllService} from './allfundraisers-service';
import {Fundraiser} from './fundraiser';

@Component({
  selector: 'app-allfundraisers',
  templateUrl: './allfundraisers.component.html',
  styleUrls: ['./allfundraisers.component.scss']
})
export class AllfundraisersComponent implements OnInit {

    allFunds: Fundraiser[];

  constructor(private allService: AllService) {
      this.allService.getAll().subscribe( json => this.addList(json));
  }

  ngOnInit() {
  }
  addList(json: any) {
      this.allFunds = json;
      console.log(this.allFunds);
  }

  setStore(fund: Fundraiser){
      localStorage.setItem('currentFund', fund.id + '');
  }


}
