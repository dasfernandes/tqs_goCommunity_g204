import { Component, OnInit } from '@angular/core';
import {FundraiserService} from './fundraiser-service';
import {Fundraiser} from './fundraiser';

@Component({
  selector: 'app-fundraiserpage',
  templateUrl: './fundraiserpage.component.html',
  styleUrls: ['./fundraiserpage.component.scss']
})
export class FundraiserpageComponent implements OnInit {


    fundraiserID: number;
    fundRaiser: Fundraiser;
  constructor(private fund: FundraiserService) {
      this.fundraiserID = parseInt(localStorage.getItem('currentFund'));
      this.fund.getAll(this.fundraiserID).subscribe( json => this.update(json));
  }

  ngOnInit() {
  }
  update( json: any ) {
      this.fundRaiser = json;
      console.log(this.fundRaiser);
  }
}
