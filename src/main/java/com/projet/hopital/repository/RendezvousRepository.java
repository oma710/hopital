package com.projet.hopital.repository;

import com.projet.hopital.entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<Rendezvous,Long> {
}
