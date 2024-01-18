package com.projet.hopital.service;

import com.projet.hopital.entities.Medecin;
import com.projet.hopital.repository.MedecinRepository;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class MedecinServiceImpl implements MedecinService{

    @Autowired
    private MedecinRepository medecinRepository;
    @Override
    public void addMedecin(MultipartFile file, Medecin medecin) throws FileUploadException {
        String filePath = "C:/spring/hopital/src/main/resources/medecin-picture/" + file.getOriginalFilename();
        try {
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            medecin.setImageName(file.getOriginalFilename());
            medecin.setImagePath(filePath);
            medecin.setSuppression(false);
            medecinRepository.save(medecin);
        } catch (Exception e) {
            throw new FileUploadException("File upload failed: " + e.getMessage());
        }

    }

    @Override
    public List<Medecin> medecinsList() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin getMedecinById(Long id) {
        return medecinRepository.findById(id).get();
    }

    @Override
    public List<Medecin> getMedecinBySpecialite(String specialite) {
        return medecinRepository.getMedecinBySpecialite(specialite);
    }

    @Override
    public void deleteMedecinById(Long id) {
        medecinRepository.updateSuppressionById(id);
    }

    @Override
    public void updateMedecin(Long id, Medecin updatedMedecin) {
        Medecin medecin = medecinRepository.findById(id).get();
        if(medecin!=null){
            medecin.setNom(updatedMedecin.getNom());
            medecin.setEmail(updatedMedecin.getEmail());
            medecin.setSpecialite(updatedMedecin.getSpecialite());
            medecin.setAdresse(updatedMedecin.getAdresse());
            medecin.setPhoneNumber(updatedMedecin.getPhoneNumber());
            medecin.setExperienceYears(updatedMedecin.getExperienceYears());
            medecin.setQualifications(updatedMedecin.getQualifications());
            medecinRepository.save(medecin);
        }
    }
}
