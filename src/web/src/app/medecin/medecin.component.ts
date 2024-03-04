import { Component, OnInit } from '@angular/core';
import { Medecin } from '../model/medecin';
import { MedecinService } from '../services/medecin.service';

@Component({
  selector: 'app-medecin',
  templateUrl: './medecin.component.html',
  styleUrls: ['./medecin.component.scss']
})
export class MedecinComponent implements OnInit {

  medecin:Medecin = new Medecin();

  constructor(private service:MedecinService){

  }

  ngOnInit(): void {
   
  }

  onSubmite(){   
      this.service.saveMedecin(this.medecin).subscribe(response=>{
        console.log('Medecin added successfully:', response);
      },
      error=>{
        console.error('Error adding medecin:', error);
      }
      )
  
       
  }

}
