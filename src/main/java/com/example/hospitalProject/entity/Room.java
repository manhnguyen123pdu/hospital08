package com.example.hospitalProject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int id;

    @Column(name = "room_number", length = 20, nullable = false, unique = true)
    private String roomNumber;

    @Column(name = "room_type", length = 50)
    private String roomType;

    @Column(name = "status", length = 30)
    private String status;


//    department_id
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    public Room() {
    }

    public Room(String roomNumber, String roomType, String status, Department department, List<Appointment> appointments) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.department = department;
        this.appointments = appointments;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
