
package com.example.appointmentservice.controller;

import com.example.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Object createAppointment(@RequestParam Long doctorId) {
        return appointmentService.createAppointment(doctorId);
    }
}