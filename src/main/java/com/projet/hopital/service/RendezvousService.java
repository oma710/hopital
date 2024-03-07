package com.projet.hopital.service;

import com.projet.hopital.DTO.RendezvousDTO;
import com.projet.hopital.Utile.TimeSlot;
import com.projet.hopital.entities.Rendezvous;

import java.util.Date;
import java.util.List;

public interface RendezvousService {
    void addRendezV(RendezvousDTO rendezvousDTO);
    List<Rendezvous> listRebdezvous();
    List<Rendezvous> freeTime(Date date, Long id);
    public List<TimeSlot> time();
}
