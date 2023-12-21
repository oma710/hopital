package com.projet.hopital.service;

import com.projet.hopital.entities.Medecin;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MedecinService {
    void addMedecin(MultipartFile file, Medecin medecin) throws FileUploadException;
    List<Medecin> medecinsList();
    Medecin getMedecinById(Long id);
    List<Medecin> getMedecinBySpecialite(String specialite);
    void deleteMedecinById(Long id);
    void updateMedecin(Long id, Medecin updatedMedecin);
}
