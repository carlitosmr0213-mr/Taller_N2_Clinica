package co.edu.uptc.clinic.service;

import java.util.Optional;
import java.util.Set;

import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.repository.PatientRepository;

public class PatientService {

	private PatientRepository patientRepository;

	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public boolean registerPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public boolean addMedicationToPatient(IdentificationTypeEnum type, Long idPatient, String medication) {
		Optional<Patient> found = patientRepository.findByIdentificaion(type, idPatient);
		if (found.isEmpty()) {
			return false;	
		}
		return found.get().addMedication(medication);
	}
	
	public Optional<Patient> findPatient(IdentificationTypeEnum type, Long idPatient){
		return patientRepository.findByIdentificaion(type, idPatient);
	}
	
	public Set<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	public boolean patientExist(IdentificationTypeEnum type, Long idPatient) {
		return patientRepository.existsByIdentification(type, idPatient);
	}
	
	public int getTotalPatients(){
		return patientRepository.count();
	}
	
}
