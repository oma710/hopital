package com.projet.hopital.endPoint;

import com.projet.hopital.entities.Medecin;
import com.projet.hopital.service.MedecinServiceImpl;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/medecin")
@CrossOrigin("*")
public class MedecinController {
   @Autowired
   private MedecinServiceImpl medecinService;

    @PostMapping(value = "/add",consumes = {"multipart/form-data"})
    public ResponseEntity<String> addMedecin(@RequestPart("file") MultipartFile file, Medecin medecin) throws FileUploadException {
        medecinService.addMedecin(file,medecin);
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

    public ResponseEntity<Void> updateMedecin(@PathVariable Long id, @RequestBody Medecin updatedMedecin) {
        medecinService.updateMedecin(id, updatedMedecin);
        return ResponseEntity.noContent().build();
    }
}
