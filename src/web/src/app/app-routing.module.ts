import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RendezvousComponent } from './rendezvous/rendezvous/rendezvous.component';
import { PatientComponent } from './rendezvous/patient/patient.component';
import { MedecinComponent } from './medecin/medecin.component';

const routes: Routes = [
  {path:"patient", component:PatientComponent},
  {path:"rendezvous", component:RendezvousComponent},
  {path:"medecin", component:MedecinComponent},
  {path:"",redirectTo:"patient",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
