package co.edu.uptc.clinic.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.enums.PriorityEnum;

public class Patient {
	
	private IdentificationTypeEnum identificationType;
    private Long idPatient;
    private String firstName;
    private String lastName;
    private String email;
    private PriorityEnum priority;
    private Set<String> medicationHistory;
    
    
	public Patient(IdentificationTypeEnum identificationType, long idPatient, String firstName, String lastName,
			String email, PriorityEnum priority, Set<String> medicationHistory) {
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
	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(IdentificationTypeEnum identificationType) {
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
	public PriorityEnum getPriority() {
		return priority;
	}
	public void setPriority(PriorityEnum priority) {
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
    	/*this objeto actual se compara con obj y si apuntan al mismo lugar de memoria son iguales*/
    	if (this == obj) return true;
    	if (obj == null || getClass() != obj.getClass()) return false;
    	
    	Patient patient = (Patient) obj;
    	return this.idPatient.equals(patient.getIdPatient()) 
    			&& this.identificationType.equals(patient.getIdentificationType());
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(identificationType, idPatient);
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
