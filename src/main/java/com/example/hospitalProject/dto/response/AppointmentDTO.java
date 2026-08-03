package com.example.hospitalProject.dto.response;

import com.example.hospitalProject.entity.Doctor;
import com.example.hospitalProject.entity.Invoice;
import com.example.hospitalProject.entity.Patient;
import com.example.hospitalProject.entity.Room;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppointmentDTO {
    private int id;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String room;
    private String patient;
    private String status;

    public AppointmentDTO() {
    }

    public AppointmentDTO(int id, LocalDate appointmentDate, LocalTime appointmentTime, String room, String patient, String status) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.room = room;
        this.patient = patient;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
