package com.projet.hopital.service;

import com.projet.hopital.DTO.MedecinDTO;
import com.projet.hopital.entities.Medecin;
import com.projet.hopital.enumeration.Specialite;

import java.util.List;

public interface MedecinService {
    void addMedecin( MedecinDTO medecinDTO);
    List<Medecin> medecinsList();
    Medecin getMedecinById(Long id);
    List<Medecin> getMedecinBySpecialite(Specialite specialite);
    void deleteMedecinById(Long id);
    void updateMedecin(Long id, Medecin updatedMedecin);
}
