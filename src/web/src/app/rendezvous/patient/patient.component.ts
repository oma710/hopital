import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/model/patient';
import { PatientService } from 'src/app/services/patient.service';


@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.scss']
})
export class PatientComponent implements OnInit{


  patient:Patient = new Patient();
  constructor(private service:PatientService, private router:Router){

  }

  ngOnInit(): void {

  }

  onSubmite(){

    this.service.addPatient(this.patient).subscribe(
      (response:Patient) => {
        const patientId = response.id;
        this.router.navigate(['/rendezvous'], { queryParams: { patientId: patientId } });
      },
      error => {
        console.error('Error:', error);
      }
    );
  }


}
