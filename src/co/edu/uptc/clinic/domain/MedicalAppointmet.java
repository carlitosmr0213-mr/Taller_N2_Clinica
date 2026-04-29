package co.edu.uptc.clinic.domain;

import java.time.LocalTime;

public class MedicalAppointmet {
	
    private String idMedicalAppointment;
    private LocalTime timeAppointment;
    private Patient patient;
    private Doctor doctor;
    
	public MedicalAppointmet(String idMedicalAppointment, LocalTime timeAppointment, Patient patient, Doctor doctor) {
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
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "MedicalAppointmet [idMedicalAppointment=" + idMedicalAppointment 
				+ ", timeAppointment="	+ timeAppointment 
				+ ", patient=" + patient 
				+ ", doctor="  + doctor + "]";
	}
	
	
}
