import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { map } from 'rxjs';
import { TimeSlot } from 'src/app/model/TimeSlot';
import { Medecin, Specialite } from 'src/app/model/medecin';
import { Rendezvous } from 'src/app/model/rendezvous';
import { MedecinService } from 'src/app/services/medecin.service';
import { RendezvousService } from 'src/app/services/rendezvous.service';

@Component({
  selector: 'app-rendezvous',
  templateUrl: './rendezvous.component.html',
  styleUrls: ['./rendezvous.component.scss']
})
export class RendezvousComponent implements OnInit {

  timeSlot!: TimeSlot[];
  rendezvous = new Rendezvous();
  specialites!: Specialite[];
  medecinList!:Medecin[];
  freeheure:any=[];
  time = false;


  constructor(private service: RendezvousService, private medcinService: MedecinService, private route:ActivatedRoute) {

  }

  ngOnInit(): void {
    this.service.getAllTime().subscribe((responce: TimeSlot[]) => {
      this.timeSlot = responce;
    })
    this.medcinService.specialite().subscribe(responce => {
      this.specialites = responce
      console.log(this.specialites)
    })
    this.route.queryParams.subscribe(params => {
      this.rendezvous.patientId = params['patientId'];
  });
  }

  saveRendezvous() {
    this.service.saveRendezvous(this.rendezvous).subscribe(response=>{

    },
      error => {console.log(error)
    },
      () => console.log('finale')
    )
  }

  Addcity(arg0: number) {
    this.rendezvous.slot = arg0;
  }

  onReasonSelected() {
    const specialiteEnumValue = this.rendezvous.reason as unknown as Specialite;
    this.medcinService.medecin(specialiteEnumValue).subscribe((response:Medecin[])=>{
         this.medecinList = response;
         console.log(this.medecinList)
    })
  }

  getFreeTime() {
   const id = this.rendezvous.medecinId;
   const date = this.rendezvous.dateRDV;
   this.medcinService.getfreeTime(date,id).subscribe(response=>{
     this.freeheure =  response;
     this.time = true;
     console.log(this.freeheure)
   })
  }

}
