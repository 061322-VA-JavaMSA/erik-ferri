import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutMeComponent } from './about-me/about-me.component';
import { TwoTruthsAndALieComponent } from './two-truths-and-a-lie/two-truths-and-a-lie.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutMeComponent,
    TwoTruthsAndALieComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
