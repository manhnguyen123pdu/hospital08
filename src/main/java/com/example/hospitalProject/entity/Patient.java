package com.example.hospitalProject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int id;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "phone", length = 20)
    private String phoneNumber;

    @Column(name ="email", length = 100)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    public Patient() {
    }

    public Patient(String fullName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, LocalDateTime createdAt, List<Appointment> appointments) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.createdAt = createdAt;
        this.appointments = appointments;
    }
}
