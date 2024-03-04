package com.projet.hopital.endPoint;

import com.projet.hopital.DTO.MedecinDTO;
import com.projet.hopital.entities.Medecin;
import com.projet.hopital.service.MedecinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medecin")
@CrossOrigin("*")
public class MedecinController {
   @Autowired
   private MedecinServiceImpl medecinService;

    @PostMapping("/add")
    public ResponseEntity<String> addMedecin(MedecinDTO medecinDTO) {
        medecinService.addMedecin(medecinDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Medecin added successfully");
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<String> deleteMedecin(@PathVariable Long id) {
        try {
            medecinService.deleteMedecinById(id);
            return ResponseEntity.ok("Medecin suppression updated successfully");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update Medecin suppression");
        }
    }

    @GetMapping("/specialite")
    public List<String> medecinSpecialiteList(){
        List<Medecin> medecins = medecinService.medecinsList();
        List<String> specialite = medecins.stream().map(Medecin::getSpecialite).map(sp->sp.toString()).distinct().collect(Collectors.toList());
        return specialite;
    }

    public ResponseEntity<Void> updateMedecin(@PathVariable Long id, @RequestBody Medecin updatedMedecin) {
        medecinService.updateMedecin(id, updatedMedecin);
        return ResponseEntity.noContent().build();
    }
}
