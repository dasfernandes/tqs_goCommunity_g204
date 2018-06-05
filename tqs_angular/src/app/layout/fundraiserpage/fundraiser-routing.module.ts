import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FundraiserpageComponent } from './fundraiserpage.component';

const routes: Routes = [
    {
        path: '', component: FundraiserpageComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class FundraiserRoutingModule {
}
