package com.projet.hopital.repository;

import com.projet.hopital.entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RendezvousRepository extends JpaRepository<Rendezvous,Long> {
    //@Query("SELECT r FROM Rendezvous r JOIN medecin m ON r.medecin_id = m.id WHERE r.daterdv = :date AND r.medecin.id = :id")
    //List<Rendezvous> freetime(@Param("date") Date date, @Param("id") Long id);

    @Query("SELECT r FROM Rendezvous r JOIN r.medecin m WHERE r.dateRDV = :date AND m.id = :id")
    List<Rendezvous> freetime(@Param("date") Date date, @Param("id") Long id);

    @Query("SELECT r FROM Rendezvous r JOIN r.medecin m WHERE r.dateRDV = :date AND m.id = :id")
    List<Integer> freetimelist(@Param("date") Date date, @Param("id") Long id);
}