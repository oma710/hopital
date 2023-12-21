package com.projet.hopital.service;

import com.projet.hopital.entities.Patient;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);
    List<Patient> patientList();
}
