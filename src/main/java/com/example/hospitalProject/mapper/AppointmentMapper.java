package com.example.hospitalProject.mapper;

import com.example.hospitalProject.dto.response.AppointmentDTO;
import com.example.hospitalProject.entity.Appointment;

public class AppointmentMapper {
    public static AppointmentDTO toDTO (Appointment appointment){
        AppointmentDTO appointmentDTO=new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDTO.setAppointmentTime(appointment.getAppointmentTime());
        appointmentDTO.setRoom(appointment.getRoom().getRoomNumber());
        appointmentDTO.setPatient(appointment.getPatient().getFullName());
        appointmentDTO.setStatus(appointment.getStatus());

        return appointmentDTO;
    }
}
