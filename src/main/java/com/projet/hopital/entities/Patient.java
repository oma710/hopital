package com.projet.hopital.entities;

import com.projet.hopital.enumeration.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String nom;
    private String prenom;
    private String email;
    private String contact;
    private String contactencasdurgence;
    @Embedded
    private Address  address;
    private int age;
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
