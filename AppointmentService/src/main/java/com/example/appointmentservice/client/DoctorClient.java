package com.example.appointmentservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoctorClient {

    @Autowired
    private RestTemplate restTemplate;

    public Object getDoctorById(Long doctorId) {
        return restTemplate.getForObject(
                "http://DOCTOR-SERVICE/api/v1/doctors/" + doctorId,
                Object.class
        );
    }
}
