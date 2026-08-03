package com.example.hospitalProject.controller;

import com.example.hospitalProject.dto.request.CreateDoctor;
import com.example.hospitalProject.dto.response.DoctorDetailResponseDTO;
import com.example.hospitalProject.dto.response.DoctorResponseDTO;
import com.example.hospitalProject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping()
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDetailResponseDTO> getDoctorById(@PathVariable String id){
        return ResponseEntity.ok(doctorService.getDoctorById(Integer.parseInt(id)));
    }
    @PostMapping()
    public String addDoctor(@RequestBody CreateDoctor createDoctor){
        doctorService.createDoctor(createDoctor);
        return "Doctor added successfully";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable String id){
        doctorService.deleteDoctorById(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }

}
