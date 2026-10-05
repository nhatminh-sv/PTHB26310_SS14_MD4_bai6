package com.example.appointmentservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientClient {

    @Autowired
    private RestTemplate restTemplate;

    public Object getPatientById(Long patientId) {
        return restTemplate.getForObject(
                "http://PATIENT-SERVICE/api/v1/patients/" + patientId,
                Object.class
        );
    }
}