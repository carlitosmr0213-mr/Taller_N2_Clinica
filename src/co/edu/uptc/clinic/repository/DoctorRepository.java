package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;

public class DoctorRepository {
	
	private Set<Doctor> doctors;

	public DoctorRepository() {
		this.doctors = new HashSet<>();
	}
	
	public Set<Doctor> finAll(){
		return doctors;
	}
	
	public boolean save(Doctor doctor) {
		if(existByIdentification(doctor.getIdentificationType(), doctor.getMedicalId())) {
			return false;
		}
		return doctors.add(doctor);
	}
	
	public Optional<Doctor> findByIdentification(IdentificationTypeEnum type, Long medicalId){
		return doctors.stream().filter(d -> d.getIdentificationType().equals(type) && d.getMedicalId().equals(medicalId))
				.findFirst();
	}
	
	public boolean existByIdentification(IdentificationTypeEnum type, Long medicalId) {
		return doctors.stream()
				.anyMatch(d -> d.getIdentificationType().equals(type) && d.getMedicalId().equals(medicalId));
	}
	
	public int count() {
		return doctors.size();
	}
	
}
