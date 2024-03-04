package com.projet.hopital.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RendezvousDTO {
    private Long Id;
    private String nature_of_the_appointment;
    private String reason;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "yyyy-MM-dd")
   // private Date dateRDV;
    //@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
  //  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME,pattern = "HH:mm")
    private Date heureRDV;
    private int slot;
    private Long patientId;
    private Long medecinId;
}
