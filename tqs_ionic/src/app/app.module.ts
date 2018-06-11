import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { ListPage } from '../pages/list/list';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import {AllService} from "../pages/list/allfundraisers-service";

import {HttpClientModule} from "@angular/common/http";
import {FundraiserpagePage} from "../pages/fundraiserpage/fundraiserpage";
import {FundService} from "../pages/fundraiserpage/allfundraisers-service";

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    ListPage,
    FundraiserpagePage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    ListPage,
    FundraiserpagePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    AllService,
    FundService,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
