package com.projet.hopital.Utile;

import org.springframework.context.annotation.Configuration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class SlotService {
    private static final Map<Integer, String> TIME_SLOTS = new HashMap<>();
    static {
        TIME_SLOTS.put(1, "08:00");
        TIME_SLOTS.put(2, "08:30");
        TIME_SLOTS.put(3, "09:00");
        TIME_SLOTS.put(4, "09:30");
        TIME_SLOTS.put(5, "10:00");
        TIME_SLOTS.put(6, "10:00");
        TIME_SLOTS.put(7, "10:30");
        TIME_SLOTS.put(8, "11:00");
        TIME_SLOTS.put(9, "11:30");
        TIME_SLOTS.put(10, "12:00");
    }

    public List<TimeSlot> timeSlots(){
     return TIME_SLOTS.entrySet().stream()
             .map(entry -> new TimeSlot(entry.getKey(), entry.getValue()))
             .collect(Collectors.toList());
    }
    private Map<String, Map<Long, Set<Integer>>> assignedSlots = new HashMap<>();

    public Date assignTimeSlot(int slotNumber, String dateRDV, Long medecinId) {
        String time = TIME_SLOTS.get(slotNumber);
        if (time == null) {
            throw new IllegalArgumentException("Invalid slot number: " + slotNumber);
        }

        // Check if the slot is already assigned for the given date and medecinId
        Map<Long, Set<Integer>> slotsForDate = assignedSlots.get(dateRDV);
        if (slotsForDate != null && slotsForDate.containsKey(medecinId) && slotsForDate.get(medecinId).contains(slotNumber)) {
            throw new IllegalArgumentException("Slot " + slotNumber + " is already assigned for date " + dateRDV + " and medecinId " + medecinId);
        }

        // If the slot is not assigned, add it to the record
        if (slotsForDate == null) {
            slotsForDate = new HashMap<>();
            assignedSlots.put(dateRDV, slotsForDate);
        }
        Set<Integer> slotsForMedecin = slotsForDate.get(medecinId);
        if (slotsForMedecin == null) {
            slotsForMedecin = new HashSet<>();
            slotsForDate.put(medecinId, slotsForMedecin);
        }
        slotsForMedecin.add(slotNumber);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            return sdf.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing time: " + time, e);
        }
    }
}
