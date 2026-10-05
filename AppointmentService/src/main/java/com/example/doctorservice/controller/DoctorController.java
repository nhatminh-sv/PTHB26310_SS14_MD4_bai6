package com.example.doctorservice.controller;

import com.example.doctorservice.entity.Doctor;
import com.example.doctorservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors()
                .stream()
                .map(doctor -> {
                    Doctor result = new Doctor();
                    result.setId(doctor.getId());
                    result.setName(doctor.getName());
                    result.setSpecialization(doctor.getSpecialization());
                    return result;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }
}