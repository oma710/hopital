import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RendezvousComponent } from './rendezvous/rendezvous/rendezvous.component';
import { PatientComponent } from './rendezvous/patient/patient.component';

const routes: Routes = [
  {path:"patient", component:PatientComponent},
  {path:"rendezvous", component:RendezvousComponent},
  {path:"",redirectTo:"patient",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
