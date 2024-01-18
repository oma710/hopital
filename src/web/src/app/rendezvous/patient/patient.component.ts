import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/model/patient';
import { PatientService } from 'src/app/services/patient.service';


@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss']
})
export class PatientComponent implements OnInit{

 
  patient:Patient = new Patient();
  constructor(private service:PatientService){
      
  }

  ngOnInit(): void {
   
  }

  onSubmite(){
    console.log("add patient")
    this.service.addPatient(this.patient).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.error('Error:', error);
      }
    );
  }


}
