import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http : HttpClient) { }

  addPatient(patient: Patient):Observable<Object>{
    return this.http.post("http://localhost:8080/patient/add", patient);
  }
}
