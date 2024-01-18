import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from '../modele/patient';

@Injectable({
  providedIn: 'root'
})
export class MedecinService {

  constructor(private http : HttpClient) { }

  listofmedecin():Observable<any>{
    return this.http.get("http://localhost:8080/api/medecinslist")
  }


}
