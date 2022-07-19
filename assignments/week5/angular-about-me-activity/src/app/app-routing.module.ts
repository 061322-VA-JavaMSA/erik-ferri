import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutMeComponent } from './about-me/about-me.component';
import { TwoTruthsAndALieComponent } from './two-truths-and-a-lie/two-truths-and-a-lie.component';

const routes: Routes = [
  { path: 'about-me', component: AboutMeComponent },
  { path: 'two-truths-and-a-lie', component: TwoTruthsAndALieComponent },
  { path: '', redirectTo: '/about-me', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
