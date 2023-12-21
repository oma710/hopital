package com.projet.hopital.endPoint;

import com.projet.hopital.DTO.RendezvousDTO;
import com.projet.hopital.entities.Rendezvous;
import com.projet.hopital.service.RendezvousService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rendezvous")
@CrossOrigin("*")
public class RendezvousController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RendezvousService rendezvousService;
    @PostMapping("/save")
    public ResponseEntity<String> addRendezV(@RequestBody RendezvousDTO rendezvousDTO) {
        try{
            rendezvousService.addRendezV(rendezvousDTO);
            return new ResponseEntity<>("Rendezvous added successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error adding rendezvous: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
