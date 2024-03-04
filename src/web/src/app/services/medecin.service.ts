import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Medecin, Specialite } from '../model/medecin';


@Injectable({
  providedIn: 'root'
})
export class MedecinService {
  private baseUrl = 'http://localhost:8080';
  constructor(private http : HttpClient) { }

  listofmedecin():Observable<any>{
    return this.http.get(this.baseUrl+"/api/medecinslist")
  }
  saveMedecin(medecin:Medecin):Observable<any>{
    return this.http.post(this.baseUrl+"/medecin/add",medecin);
  }
  specialite():Observable<any>{
    return this.http.get(`${this.baseUrl}/medecin/specialite`)
  }
 
  medecin(specialite:Specialite):Observable<Medecin[]>{
    return this.http.get<Medecin[]>(`${this.baseUrl}/api/medecinsbyspecialite?specialite=${specialite}`)
  }
  getfreeTime(date:Date, id:any){
    return this.http.get(`${this.baseUrl}/rendezvous/freetime/${date}/${id}`);
  }
}
