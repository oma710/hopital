

  export class Patient {
    id!: number;
    code!: string;
    nom!: string;
    prenom!: string;
    email!: string;
    contact!: string;
    contactencasdurgence!: string;
    address: Address = new Address();
    age!: number;
    genre!: Genre;
  }
  
  export enum Genre {
    // Define your genre options here if not already defined in Angular
   MÂLE,
   FEMALE,
   AUTRE,
   JE_PRÉFÈRE_NEPAS_LE_DIRE
    // Add more options as needed
  }
  
  export class Address {
    rue!: string;
    ville!: string;
    zip!: string;
  }