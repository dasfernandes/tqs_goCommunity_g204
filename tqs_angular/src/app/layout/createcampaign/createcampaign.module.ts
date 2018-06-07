import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PageHeaderModule } from './../../shared';
import {CreatecampaignComponent} from './createcampaign.component';
import {CreatecampaignRoutingModule} from './createcampaign-routing.module';
import {FormsModule} from '@angular/forms';

@NgModule({
    imports: [CommonModule, CreatecampaignRoutingModule, PageHeaderModule, FormsModule],
    declarations: [CreatecampaignComponent]
})
export class CreatecampaignModule {}
