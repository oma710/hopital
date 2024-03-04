import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TimeSlot } from '../model/TimeSlot';

@Injectable({
  providedIn: 'root'
})
export class RendezvousService {

  constructor(private http:HttpClient) { }

  private readonly urlApi = 'http://localhost:8080/rendezvous';

  getAllTime():Observable<TimeSlot[]>{
    return this.http.get<TimeSlot[]>(this.urlApi+"/time")
  }
}
