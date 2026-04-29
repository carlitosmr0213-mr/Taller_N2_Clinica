package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Set;

import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationType;

public class PatientRepository {
	
	private Set<Patient> patients;

	public PatientRepository() {
		this.patients = new HashSet<Patient>();
	}
	
	public boolean addPatient(Patient patient) {
		return this.patients.add(patient);
	}
	
	public Set<Patient> findAll(){
		return this.patients;
	}
	
	
	public Patient findPatientById(Long idPatient) {
		return this.patients.stream().filter(p -> p.getIdPatient().equals(idPatient))
		.findFirst().orElse(null);
	}
	
	
	public boolean existsByIdentification(IdentificationType type, long idPatient) {
        return patients.stream()
                .anyMatch(p -> p.getIdentificationType() == type && p.getIdPatient() == idPatient);
    }
	
}
