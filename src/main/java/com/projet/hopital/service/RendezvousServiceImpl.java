package com.projet.hopital.service;

import com.projet.hopital.DTO.RendezvousDTO;
import com.projet.hopital.entities.Rendezvous;
import com.projet.hopital.repository.RendezvousRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezvousServiceImpl implements RendezvousService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RendezvousRepository rendezvousRepository;

    @Override
    public void addRendezV(RendezvousDTO rendezvousDTO) {
        Rendezvous rendezvous = modelMapper.map(rendezvousDTO, Rendezvous.class);
        rendezvousRepository.save(rendezvous);
    }

    @Override
    public List<Rendezvous> listRebdezvous() {
        return rendezvousRepository.findAll();
    }
}
