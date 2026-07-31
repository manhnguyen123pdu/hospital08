package com.example.hospitalProject.dto.response;

public class DoctorResponseDTO {
    private int doctorId;
    private String fullName;
    private String specialization;
    private String departmentName;
    private String phoneNumber;
    private String email;
    private String status;

    public DoctorResponseDTO() {
    }

    public DoctorResponseDTO(int doctorId, String doctorName, String specialization, String departmentName, String phoneNumber, String email, String status) {
        this.doctorId = doctorId;
        this.fullName = doctorName;
        this.specialization = specialization;
        this.departmentName = departmentName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return fullName;
    }

    public void setDoctorName(String doctorName) {
        this.fullName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
