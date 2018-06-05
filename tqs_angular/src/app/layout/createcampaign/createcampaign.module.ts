import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PageHeaderModule } from './../../shared';
import {CreatecampaignComponent} from './createcampaign.component';
import {CreatecampaignRoutingModule} from './createcampaign-routing.module';

@NgModule({
    imports: [CommonModule, CreatecampaignRoutingModule, PageHeaderModule],
    declarations: [CreatecampaignComponent]
})
export class CreatecampaignModule {}
