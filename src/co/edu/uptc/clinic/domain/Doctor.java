package co.edu.uptc.clinic.domain;

import co.edu.uptc.clinic.enums.IdentificationType;

public class Doctor {
	
    private IdentificationType identificationType;
    private long medicalId;
    private String firstName;
    private String lastName;
    private String specialty;
    private int yearsOfExperience;
    
	public Doctor(IdentificationType identificationType, long medicalId, String firstName, String lastName,
			String specialty, int yearsOfExperience) {
		super();
		this.identificationType = identificationType;
		this.medicalId = medicalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.yearsOfExperience = yearsOfExperience;
	}

	public IdentificationType getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}
	public long getMedicalId() {
		return medicalId;
	}
	public void setMedicalId(long medicalId) {
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
		return "Doctor [identificationType=" + identificationType 
				+ ", medicalId=" + medicalId 
				+ ", firstName=" + firstName 
				+ ", lastName="  + lastName 
				+ ", specialty=" + specialty 
				+ ", yearsOfExperience=" + yearsOfExperience + "]";
	}
	
    
}
