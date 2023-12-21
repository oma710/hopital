import { Component, OnInit } from '@angular/core';
import { MedecinService } from 'src/app/services/medecin.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.scss']
})
export class CardsComponent implements OnInit {

  medecin:any;
  constructor(private seerviceMedecin :MedecinService){

  }

  ngOnInit(): void {
    this.seerviceMedecin.listofmedecin().subscribe(data =>{
       this.medecin = data;
       console.log(this.medecin)
    })
  }

}
