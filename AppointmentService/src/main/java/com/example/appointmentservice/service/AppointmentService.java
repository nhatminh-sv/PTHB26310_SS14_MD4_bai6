package com.example.appointmentservice.service;

import com.example.appointmentservice.client.DoctorClient;
import com.example.appointmentservice.client.PatientClient;
import com.example.appointmentservice.dto.AppointmentRequest;
import com.example.appointmentservice.entity.Appointment;
import com.example.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientClient patientClient;

    @Autowired
    private DoctorClient doctorClient;

    public Appointment createAppointment(AppointmentRequest request) {

        // Kiểm tra Patient có tồn tại không
        patientClient.getPatientById(request.getPatientId());

        // Kiểm tra Doctor có tồn tại không
        doctorClient.getDoctorById(request.getDoctorId());

        // Nếu cả Patient và Doctor tồn tại thì lưu lịch hẹn
        Appointment appointment = new Appointment();

        appointment.setPatientId(request.getPatientId());
        appointment.setDoctorId(request.getDoctorId());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setReason(request.getReason());
        appointment.setStatus("PENDING");

        return appointmentRepository.save(appointment);
    }
}