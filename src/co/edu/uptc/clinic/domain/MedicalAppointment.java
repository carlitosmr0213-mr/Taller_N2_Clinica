package co.edu.uptc.clinic.domain;

import java.time.LocalTime;
import java.util.Objects;

public class MedicalAppointment {
	
    private String idMedicalAppointment;
    private LocalTime timeAppointment;
    private Patient patient;
    private Doctor doctor;
    
	public MedicalAppointment(String idMedicalAppointment, LocalTime timeAppointment, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppointment = idMedicalAppointment;
		this.timeAppointment = timeAppointment;
		this.patient = patient;
		this.doctor = doctor;
	}

	public String getIdMedicalAppointment() {
		return idMedicalAppointment;
	}
	public void setIdMedicalAppointment(String idMedicalAppointment) {
		this.idMedicalAppointment = idMedicalAppointment;
	}
	public LocalTime getTimeAppointment() {
		return timeAppointment;
	}
	public void setTimeAppointment(LocalTime timeAppointment) {
		this.timeAppointment = timeAppointment;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj ==null || getClass() != obj.getClass()) return false;
		
		MedicalAppointment appointment= (MedicalAppointment) obj;
		return Objects.equals(idMedicalAppointment, appointment.getIdMedicalAppointment());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idMedicalAppointment);
	}

	@Override
	public String toString() {
		return "MedicalAppointmet [idMedicalAppointment=" + idMedicalAppointment 
				+ ", timeAppointment="	+ timeAppointment 
				+ ", patient=" + patient 
				+ ", doctor="  + doctor + "]";
	}
	
	
}
