package com.example.hospitalProject.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CreateDepartment {
    @NotBlank(message = "Tên khoa không được để trống")
    private String departmentName;
    @NotBlank(message = "Mô tả không được để trống")
    private String description;
    @NotBlank(message = "Số điện thoại không được để trống")
    private String phone;

    public CreateDepartment() {
    }

    public CreateDepartment(String departmentName, String description, String phone) {
        this.departmentName = departmentName;
        this.description = description;
        this.phone = phone;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
