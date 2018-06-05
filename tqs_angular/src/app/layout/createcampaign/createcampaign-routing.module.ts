import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreatecampaignComponent } from './createcampaign.component';

const routes: Routes = [
    {
        path: '', component: CreatecampaignComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class CreatecampaignRoutingModule {
}
