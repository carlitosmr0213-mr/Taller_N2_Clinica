package co.edu.uptc.clinic.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.repository.DoctorRepository;

public class DoctorService {
	
	private DoctorRepository doctorRepository;

	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	public boolean registerDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Optional<Doctor> findDoctor(IdentificationTypeEnum type, Long medicalId){
		return doctorRepository.findByIdentification(type, medicalId);
	}
	
	public Set<Doctor> getAllDoctors(){
		return doctorRepository.finAll();
	}	
	
	public boolean doctorExists(IdentificationTypeEnum type, Long medicalId) {
		return doctorRepository.existByIdentification(type, medicalId);
	}
	
	public List<Doctor> getDoctorSortedByExperience(){
		return doctorRepository.finAll().stream().sorted().collect(Collectors.toList());
	}
	
	public int getTotalDoctors() {
		return doctorRepository.count();
	}
	
	
}
