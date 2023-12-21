package com.projet.hopital.endPoint;

import com.projet.hopital.entities.Patient;
import com.projet.hopital.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/add")
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient added successfully");
    }
}
