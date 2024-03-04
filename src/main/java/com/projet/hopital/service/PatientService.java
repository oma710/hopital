package com.projet.hopital.service;

import com.projet.hopital.entities.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    List<Patient> patientList();
}
