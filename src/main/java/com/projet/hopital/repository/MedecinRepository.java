package com.projet.hopital.repository;

import com.projet.hopital.entities.Medecin;
import com.projet.hopital.enumeration.Specialite;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin,Long> {
     @Query("SELECT m FROM Medecin m WHERE m.specialite = :specialite")
     List<Medecin> getMedecinBySpecialite(@Param("specialite") Specialite specialite);

     @Modifying
     @Transactional
     @Query("UPDATE Medecin m SET m.suppression = true WHERE m.id = :id")
     void updateSuppressionById(@Param("id") Long id);
}
