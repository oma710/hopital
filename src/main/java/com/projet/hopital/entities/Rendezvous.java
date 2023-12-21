package com.projet.hopital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Rendezvous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nature_of_the_appointment;
    private String reason;
    private Date dateRDV;
    private Date heureRDV;
    private String location;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;

}
