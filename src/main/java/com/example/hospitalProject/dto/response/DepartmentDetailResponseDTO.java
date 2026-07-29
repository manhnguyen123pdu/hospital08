package com.example.hospitalProject.dto.response;

import com.example.hospitalProject.entity.Doctor;

import java.util.List;

public class DepartmentDetailResponseDTO {
    private int departmentId;
    private String departmentName;
    private String description;
    private String phone;
    List<DoctorDTO> doctors;

    public DepartmentDetailResponseDTO() {
    }

    public DepartmentDetailResponseDTO(int departmentId, String departmentName, String description, String phone, List<DoctorDTO> doctors) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.description = description;
        this.phone = phone;
        this.doctors = doctors;
    }

    public List<DoctorDTO> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorDTO> doctors) {
        this.doctors = doctors;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
