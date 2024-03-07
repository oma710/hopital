package com.projet.hopital.endPoint;

import com.projet.hopital.DTO.RendezvousDTO;
import com.projet.hopital.Utile.TimeSlot;
import com.projet.hopital.entities.Rendezvous;
import com.projet.hopital.service.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rendezvous")
@CrossOrigin("*")
public class RendezvousController {

    @Autowired
    private RendezvousService rendezvousService;

    @PostMapping("/save")
    public void addRendezV(@RequestBody RendezvousDTO rendezvousDTO) {
        rendezvousService.addRendezV(rendezvousDTO);
    }

   /* @GetMapping("/freetime/{date}/{id}")
    public List<Rendezvous> freeTime(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date, @PathVariable("id") Long id) {
        return rendezvousService.freeTime(date, id);
    }*/

    @GetMapping("/freetime/{date}/{id}")
    public List<Integer> freeTimeList(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date, @PathVariable("id") Long id) {
        List<Rendezvous> rendezvousList = rendezvousService.freeTime(date, id);

        List<Integer> slotList = rendezvousList.stream()
                .map(Rendezvous::getSlot)
                .collect(Collectors.toList());

        return slotList;
    }

    @GetMapping("/time")
    public List<TimeSlot> time(){
        return rendezvousService.time();
    }
}
