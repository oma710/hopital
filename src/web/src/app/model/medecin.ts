export class Medecin {
    id!: number;
    nom!: string;
    prenom!:string;
    email!: string;
    specialite!: Specialite;
    numeroDeSalle!: string;
    telephone!: string;
    experienceYears!: number;
    qualifications!: string;
    suppression: boolean = false;
  }

  export enum Specialite {
    MÉDECINEINTERNE,
    PÉDIATRIE,
    CARDIOLOGIE,
    DERMATOLOGIE,
    CHIRURGIEORTHOPÉDIQUE,
    GASTROENTÉROLOGIE,
    NEUROLOGIE,
    PSYCHIATRIE,
    OPHTALMOLOGIE,
    RHUMATOLOGIE,
    NÉPHROLOGIE
}
  