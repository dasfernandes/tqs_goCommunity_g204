import { Component, OnInit } from '@angular/core';
import {CampaignService} from './fundraiser-service';

@Component({
  selector: 'app-createcampaign',
  templateUrl: './createcampaign.component.html',
  styleUrls: ['./createcampaign.component.scss']
})
export class CreatecampaignComponent implements OnInit {

  constructor(private campaignService: CampaignService) { }

  public title: string;
  public description: string;
  public image: string;
  public goal: number;
  ngOnInit() {
  }

  click(title: string, description: string, image: string, goal: number) {
      this.campaignService.createCampaign(title, description, image, goal).subscribe( json => alert('Success'));
  }

}
