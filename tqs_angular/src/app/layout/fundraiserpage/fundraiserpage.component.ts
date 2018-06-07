import { Component, OnInit } from '@angular/core';
import {FundraiserService} from './fundraiser-service';
import {Fundraiser} from './fundraiser';
import {DonateService} from './donate-service';

@Component({
  selector: 'app-fundraiserpage',
  templateUrl: './fundraiserpage.component.html',
  styleUrls: ['./fundraiserpage.component.scss']
})
export class FundraiserpageComponent implements OnInit {

    public value: number;
    fundraiserID: number;
    fundRaiser: Fundraiser;
  constructor(private fund: FundraiserService, private donate: DonateService) {
      this.fundraiserID = parseInt(localStorage.getItem('currentFund'));
      this.fund.getAll(this.fundraiserID).subscribe( json => this.update(json));
  }

  ngOnInit() {
  }
  update( json: any ) {
      this.fundRaiser = json;
      console.log(this.fundRaiser);
  }
  donate1(value: string){
        this.donate.donate(parseInt(value), this.fundraiserID).subscribe( json => console.log(json));
  }
}
