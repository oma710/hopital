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
    public Patient addPatient(Patient patient) {
        patient.setCode(UUID.randomUUID().toString());
       Patient patient1 = patientRepository.save(patient);
        return patient1;
    }

    @Override
    public List<Patient> patientList() {
        return patientRepository.findAll();
    }
}
