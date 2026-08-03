package com.example.hospitalProject.dto.request;

public class CreateDoctor {
    private String fullName;
    private String specialization;
    private int departmentId;
    private String phone;
    private String email;
    private String status;

    public CreateDoctor() {
    }

    public CreateDoctor(String fullName, String specialization, int departmentId, String phone, String email, String status) {
        this.fullName = fullName;
        this.specialization = specialization;
        this.departmentId = departmentId;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
