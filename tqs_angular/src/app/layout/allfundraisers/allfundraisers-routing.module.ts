import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllfundraisersComponent } from './allfundraisers.component';

const routes: Routes = [
    {
        path: '',
        component: AllfundraisersComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AllfundraisersRoutingModule {}
