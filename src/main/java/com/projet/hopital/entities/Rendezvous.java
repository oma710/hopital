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
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    @Temporal(TemporalType.TIME)
    private Date heureRDV;
    private int slot;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
}
