package com.example.hospitalProject.service;

import com.example.hospitalProject.dto.response.DepartmentDetailResponseDTO;
import com.example.hospitalProject.dto.response.DepartmentResponseDTO;
import com.example.hospitalProject.dto.response.DoctorDTO;
import com.example.hospitalProject.entity.Department;
import com.example.hospitalProject.entity.Doctor;
import com.example.hospitalProject.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo  departmentRepo;

//    GET ALL DEPARTMENTS
    public List<DepartmentResponseDTO> getAllDepartments(){
        List<Department> departments= departmentRepo.findAll();
        List<DepartmentResponseDTO> departmentResponseDTOS = new ArrayList<>();

        for (Department department : departments){
            DepartmentResponseDTO dto = new DepartmentResponseDTO();
            dto.setDepartmentId(department.getId());
            dto.setDepartmentName(department.getDepartmentName());
            dto.setDescription(department.getDescription());
            dto.setPhone(department.getPhone());
            dto.setNumberOfDoctors(department.getDoctors().size());
            departmentResponseDTOS.add(dto);
        }
        return departmentResponseDTOS;
    }

//    GET DEPARTMENT DETAIL
    public DepartmentDetailResponseDTO getDepartmentDetail(int id){
//         lấy department dựa vào id
        Department department = departmentRepo.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Department Not Found"
        ));

//         chuyển từ department sang departmentDetailResponseDTO
        DepartmentDetailResponseDTO dto = new DepartmentDetailResponseDTO();
        dto.setDepartmentId(department.getId());
        dto.setDepartmentName(department.getDepartmentName());
        dto.setDescription(department.getDescription());
        dto.setPhone(department.getPhone());
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (Doctor doctor : department.getDoctors()){
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setDoctorId(doctor.getId());
            doctorDTO.setFullName(doctor.getFullName());
            doctorDTO.setSpecialization(doctor.getSpecialization());
            doctorDTO.setPhone(doctor.getPhone());
            doctorDTO.setEmail(doctor.getEmail());
            doctorDTO.setStatus(doctor.getStatus());
            doctorDTOS.add(doctorDTO);
        }
        dto.setDoctors(doctorDTOS);
        return dto;
    }

//    DELETE DEPARTMENT
    public void deleteDepartment(int id){
//         tìm department xem có hay ko
        Department department = departmentRepo.findById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Department Not Found"
        ));
        departmentRepo.delete(department);
    }
}
