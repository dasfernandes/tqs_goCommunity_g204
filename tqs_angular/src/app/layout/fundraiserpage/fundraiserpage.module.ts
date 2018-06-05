import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FundraiserRoutingModule } from './fundraiser-routing.module';
import { FundraiserpageComponent } from './fundraiserpage.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, FundraiserRoutingModule, PageHeaderModule],
    declarations: [FundraiserpageComponent]
})
export class FundraiserpageModule {}
