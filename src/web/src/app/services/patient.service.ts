import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http : HttpClient) { }

  addPatient(patient: Patient):Observable<Patient>{
    return this.http.post<Patient>("http://localhost:8080/patient/add", patient);
  }
}
