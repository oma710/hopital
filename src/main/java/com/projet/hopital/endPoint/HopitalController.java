package com.projet.hopital.endPoint;

import com.projet.hopital.entities.Medecin;
import com.projet.hopital.entities.Patient;
import com.projet.hopital.service.MedecinServiceImpl;
import com.projet.hopital.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class HopitalController {
    @Autowired
    private MedecinServiceImpl medecinService;
    @Autowired
    private PatientServiceImpl patientService;
    @GetMapping("/medecinslist")
    public ResponseEntity<List<Medecin>> medecins() {
         List<Medecin> medecins = medecinService.medecinsList();
         return ResponseEntity.ok(medecins) ;
    }

    @GetMapping("/medecin/{id}")
    public ResponseEntity<Medecin> getMedecinById(@PathVariable("id") Long id) {
        Medecin medecin = medecinService.getMedecinById(id);
        if(medecin!=null){
            return ResponseEntity.ok(medecin);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/medecinsbyspecialite")
    public ResponseEntity<List<Medecin>> getMedecinBySpecialite(@RequestParam String specialite) {
        List<Medecin> medecins =  medecinService.getMedecinBySpecialite(specialite);
        if(!medecins.isEmpty()){
            return ResponseEntity.ok(medecins);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/patient")
    public ResponseEntity<List<Patient>>  patientList() {
        List<Patient> patients =  patientService.patientList();
        return ResponseEntity.ok(patients);
    }
}
