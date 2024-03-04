package com.projet.hopital.service;

import com.projet.hopital.DTO.RendezvousDTO;
import com.projet.hopital.Utile.SlotService;
import com.projet.hopital.Utile.TimeSlot;
import com.projet.hopital.entities.Rendezvous;
import com.projet.hopital.repository.RendezvousRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RendezvousServiceImpl implements RendezvousService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RendezvousRepository rendezvousRepository;
    @Autowired
    private SlotService slotService;

    @Override
    public void addRendezV(RendezvousDTO rendezvousDTO) {
        Rendezvous rendezvous = modelMapper.map(rendezvousDTO, Rendezvous.class);
        int slotNumber = rendezvous.getSlot();
        Date date=  rendezvous.getDateRDV();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(date);
        Date timeSlot = slotService.assignTimeSlot(slotNumber, dateString, rendezvousDTO.getMedecinId());
        rendezvous.setSlot(rendezvous.getSlot());
        rendezvous.setHeureRDV(timeSlot);
        rendezvousRepository.save(rendezvous);
    }

    @Override
    public List<Rendezvous> listRebdezvous() {
        return rendezvousRepository.findAll();
    }

    @Override
    public List<Rendezvous> freeTime(Date date, Long id) {
        return rendezvousRepository.freetime(date, id);
    }

    public List<TimeSlot> time(){
        return slotService.timeSlots();
    }

}
