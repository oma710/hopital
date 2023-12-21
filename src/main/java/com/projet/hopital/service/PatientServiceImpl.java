package com.projet.hopital.service;

import com.projet.hopital.entities.Patient;
import com.projet.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;
    @Override
    public void addPatient(Patient patient) {
        patient.setCode(UUID.randomUUID().toString());
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> patientList() {
        return patientRepository.findAll();
    }
}
