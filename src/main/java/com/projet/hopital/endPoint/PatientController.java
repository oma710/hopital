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
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);

        // Gather necessary information for the email
        //String to = patient.getEmail(); // Assuming Patient has an email attribute
        //String subject = "New Patient Added";
        //String body = "A new patient has been added with details: " + patient.toString(); // Adjust the body as needed

        //emailServiceImpl.sendEmail(to, subject, body);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient added successfully");
    }
}
