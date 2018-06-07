import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FundraiserRoutingModule } from './fundraiser-routing.module';
import { FundraiserpageComponent } from './fundraiserpage.component';
import { PageHeaderModule } from './../../shared';
import {FormsModule} from '@angular/forms';




@NgModule({
    imports: [CommonModule, FundraiserRoutingModule, PageHeaderModule, FormsModule],
    declarations: [FundraiserpageComponent]
})
export class FundraiserpageModule {}
