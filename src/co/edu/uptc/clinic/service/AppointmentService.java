package co.edu.uptc.clinic.service;

import java.util.Optional;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.domain.MedicalAppointment;
import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.repository.AppointmentRepository;

public class AppointmentService {
	
	private AppointmentRepository appointmentRepository;
	private PatientService patientService;
	private DoctorService doctorService;
	
	public AppointmentService(AppointmentRepository appointmentRepository, PatientService patientService,
			DoctorService doctorService) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.patientService = patientService;
		this.doctorService = doctorService;
	}
	
	public String registerAppointment(MedicalAppointment appointment, IdentificationTypeEnum patientIdtype,
			Long patientId, IdentificationTypeEnum DoctorIdType, Long medicalID) {
		if(appointmentRepository.existById(appointment.getIdMedicalAppointment())) {
			return "ERROR: YA EXISTE UNA CITA CON EL ID:"+appointment.getIdMedicalAppointment();
		}
		
		Optional<Patient> patient = patientService.findPatient(patientIdtype, patientId);
		
		if(patient.isEmpty()) {
			return "ERROR: No existe un paciente con esa indentificación";
		}
		
		Optional<Doctor> doctor = doctorService.findDoctor(DoctorIdType, medicalID);
		
		if(doctor.isEmpty()) {
			return "ERROR: No existe un doctor con esa identificación";
		}
		appointment.setPatient(patient.get());
		appointment.setDoctor(doctor.get());
		
		boolean saved = appointmentRepository.save(appointment);
		
		if(saved) {
			return "Realizado";
		}
		
		return "ERROR: No se pudo registrar la cita";
	}
	
	
	
}
