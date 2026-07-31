package com.example.hospitalProject.service;

import com.example.hospitalProject.dto.response.DoctorResponseDTO;
import com.example.hospitalProject.entity.Doctor;
import com.example.hospitalProject.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

//    GET ALL DOCTOR
    public List<DoctorResponseDTO> getAllDoctors(){
        List<Doctor> doctors = doctorRepo.findAll();
        List<DoctorResponseDTO> DoctorResponseDTOs = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorResponseDTO dto = new DoctorResponseDTO();
            dto.setDoctorId(doctor.getId());
            dto.setDoctorName(doctor.getFullName());
            dto.setSpecialization(doctor.getSpecialization());
            dto.setDepartmentName(doctor.getDepartment().getDepartmentName());
            dto.setPhoneNumber(doctor.getPhone());
            dto.setEmail(doctor.getEmail());
            dto.setStatus(doctor.getStatus());
            DoctorResponseDTOs.add(dto);
        }
        return DoctorResponseDTOs;
    }

//    DELETE DOCTOR BY ID
    public void deleteDoctorById(int id){
//         tìm doctor theo id
        Doctor doctor = doctorRepo.findById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Doctor not found"
        ));
        doctorRepo.delete(doctor);
    }
}
