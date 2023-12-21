package com.projet.hopital.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class RendezvousDTO {
    private Long id;
    private String natureOfTheAppointment;
    private String reason;
    private Date dateRDV;
    private Date heureRDV;
    private String location;
    private Long patientId;
    private Long medecinId;
}
