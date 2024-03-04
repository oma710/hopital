package com.projet.hopital.endPoint;

import com.projet.hopital.entities.Patient;
import com.projet.hopital.service.EmailServiceImpl;
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
    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }
}
