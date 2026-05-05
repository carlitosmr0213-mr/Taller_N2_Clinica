package co.edu.uptc.clinic.domain;

import java.util.Objects;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;

public class Doctor implements Comparable<Doctor>{
	
    private IdentificationTypeEnum identificationType;
    private Long medicalId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int yearsOfExperience;
    
	public Doctor(IdentificationTypeEnum identificationType, Long medicalId, String firstName, String lastName,
			String specialty, int yearsOfExperience) {
		super();
		this.identificationType = identificationType;
		this.medicalId = medicalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.yearsOfExperience = yearsOfExperience;
	}

	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(IdentificationTypeEnum identificationType) {
		this.identificationType = identificationType;
	}
	public Long getMedicalId() {
		return medicalId;
	}
	public void setMedicalId(Long medicalId) {
		this.medicalId = medicalId;
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
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	/*metodos*/
	public String getFullName() {
		return firstName +" "+ lastName;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Doctor doctor = (Doctor) obj;
		return this.medicalId.equals(doctor.getMedicalId())
				&& this.identificationType.equals(doctor.getIdentificationType());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(identificationType,medicalId);
	}

	@Override
	public String toString() {
		return "Doctor [identificationType=" + identificationType 
				+ ", medicalId=" + medicalId 
				+ ", firstName=" + firstName 
				+ ", lastName="  + lastName 
				+ ", specialty=" + specialty 
				+ ", yearsOfExperience=" + yearsOfExperience + "]";
	}

	@Override
	public int compareTo(Doctor o) {
		int experienceComparison = Integer.compare(this.yearsOfExperience, o.yearsOfExperience);
		if (experienceComparison !=0) {
			return experienceComparison;
		}
		return this.getFullName().compareTo(o.getFullName());
	}
	
    
}
