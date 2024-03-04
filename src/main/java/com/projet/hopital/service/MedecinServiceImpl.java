package com.projet.hopital.service;

import com.projet.hopital.DTO.MedecinDTO;
import com.projet.hopital.entities.Medecin;
import com.projet.hopital.enumeration.Specialite;
import com.projet.hopital.repository.MedecinRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinServiceImpl implements MedecinService{

    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void addMedecin(MedecinDTO medecinDTO)  {
        Medecin medecin = modelMapper.map(medecinDTO,Medecin.class);
            medecinRepository.save(medecin);
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
    public List<Medecin> getMedecinBySpecialite(Specialite specialite) {
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
            medecin.setPrenom(updatedMedecin.getPrenom());
            medecin.setSpecialite(updatedMedecin.getSpecialite());
            medecin.setNumeroDeSalle(updatedMedecin.getNumeroDeSalle());
            medecin.setTelephone(updatedMedecin.getTelephone());
            medecin.setExperienceYears(updatedMedecin.getExperienceYears());
            medecin.setQualifications(updatedMedecin.getQualifications());
            medecinRepository.save(medecin);
        }
    }
}
