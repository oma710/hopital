package com.projet.hopital.entities;

import com.projet.hopital.enumeration.Specialite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String imageName;
    private String imagePath;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private String adresse;
    private String phoneNumber;
    private int experienceYears;
    private String qualifications;
    private boolean suppression;
}
