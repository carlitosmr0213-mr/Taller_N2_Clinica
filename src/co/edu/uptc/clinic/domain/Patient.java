package co.edu.uptc.clinic.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import co.udu.uptc.clinic.enums.IdentificationType;
import co.udu.uptc.clinic.enums.Priority;

public class Patient {
	
	private IdentificationType identificationType;
    private Long idPatient;
    private String firstName;
    private String lastName;
    private String email;
    private Priority priority;
    private Set<String> medicationHistory;
    
    
	public Patient(IdentificationType identificationType, long idPatient, String firstName, String lastName,
			String email, Priority priority, Set<String> medicationHistory) {
		super();
		this.identificationType = identificationType;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.priority = priority;
		this.medicationHistory = new LinkedHashSet<String>();
	}
	
	/*gets y sets*/
	public IdentificationType getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Set<String> getMedicationHistory() {
		return medicationHistory;
	}
	public boolean addMedication(String medication) {
		return medicationHistory.add(medication);
	}
    
	
	/*Metodos*/
	
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
		return "Patient [identificationType=" + identificationType 
				+ ", idPatient=" + idPatient 
				+ ", firstName=" + firstName 
				+ ", lastName="  + lastName 
				+ ", email="     + email 
				+ ", priority="  + priority
				+ ", medicationHistory=" + medicationHistory + "]";
	}
    
    
    
    
}
