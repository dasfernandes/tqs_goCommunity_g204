import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AllfundraisersRoutingModule } from './allfundraisers-routing.module';
import { AllfundraisersComponent } from './allfundraisers.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, AllfundraisersRoutingModule, PageHeaderModule],
    declarations: [AllfundraisersComponent]
})
export class AllfundraisersModule {}
