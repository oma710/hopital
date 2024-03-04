package com.projet.hopital.DTO;
import com.projet.hopital.enumeration.Specialite;
import lombok.Data;

@Data
public class MedecinDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Specialite specialite;
    private String numeroDeSalle;
    private String telephone;
    private int experienceYears;
    private String qualifications;
}