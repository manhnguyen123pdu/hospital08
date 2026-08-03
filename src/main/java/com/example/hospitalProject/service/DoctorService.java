package com.example.hospitalProject.service;

import com.example.hospitalProject.dto.request.CreateDoctor;
import com.example.hospitalProject.entity.Department;
import com.example.hospitalProject.mapper.AppointmentMapper;
import com.example.hospitalProject.dto.response.DoctorDetailResponseDTO;
import com.example.hospitalProject.dto.response.DoctorResponseDTO;
import com.example.hospitalProject.entity.Doctor;
import com.example.hospitalProject.repository.DepartmentRepo;
import com.example.hospitalProject.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
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
//    GET DOCTOR BY ID
    public DoctorDetailResponseDTO  getDoctorById(int id){
        Doctor doctor = doctorRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, " Doctor with id " + id + " not found"));
        DoctorDetailResponseDTO dto = new DoctorDetailResponseDTO();
        dto.setDoctorId(doctor.getId());
        dto.setFullName(doctor.getFullName());
        dto.setSpecialization( doctor.getSpecialization());
        dto.setDepartmentName(doctor.getDepartment().getDepartmentName());
        dto.setPhoneNumber(doctor.getPhone());
        dto.setEmail(doctor.getEmail());
        dto.setStatus(doctor.getStatus());
        dto.setAppointments(
                doctor.getAppointments()
                        .stream()
                        .map(AppointmentMapper::toDTO)
                        .toList()
        );
        return dto;
    }
//    CREATE DOCTOR
    public void createDoctor(CreateDoctor createDoctor){
//        tìm department
        Department department = departmentRepo.findById(createDoctor.getDepartmentId()).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Department with id " + createDoctor.getDepartmentId() + " not found"
        ));

        Doctor newDoctor = new Doctor();
        newDoctor.setStatus(createDoctor.getStatus());
        newDoctor.setEmail(createDoctor.getEmail());
        newDoctor.setPhone(createDoctor.getPhone());
        newDoctor.setSpecialization(createDoctor.getSpecialization());;
        newDoctor.setFullName(createDoctor.getFullName());
        newDoctor.setDepartment(department);
        doctorRepo.save(newDoctor);
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
