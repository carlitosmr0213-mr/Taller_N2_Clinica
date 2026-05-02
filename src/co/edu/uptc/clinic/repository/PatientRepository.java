package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;

public class PatientRepository {
	
	private Set<Patient> patients;

	public PatientRepository() {
		this.patients = new HashSet<Patient>();
	}
	/**Registra un nuevo paciente en el sistema.
     * Verifica que no exista otro con la misma identificación ni el mismo email.
     * @param patient: paciente a registrar
     * @return true si fue registrado correctamente, false si ya existía un duplicado
     */
	public boolean save(Patient patient) {
		if (existsByIdentification(patient.getIdentificationType(), patient.getIdPatient())) {
			return false;
		}
		if (existsByEmail(patient.getEmail())) {
			return false;
		}
		return this.patients.add(patient);
	}
	
	
	public Set<Patient> findAll(){
		return this.patients;
	}
	
	public Optional<Patient> findByIdentificaion(IdentificationTypeEnum type,Long idPatient) {
		return this.patients.stream().filter(p -> p.getIdentificationType().equals(type) && p.getIdPatient().equals(idPatient))
		.findFirst();
	}
	
	public Optional<Patient> findByEmail(String email) {
		return this.patients.stream().filter(p -> p.getEmail().equals(email))
				.findFirst();
	}
	
	public boolean existsByIdentification(IdentificationTypeEnum type, Long idPatient) {
        return patients.stream()
                .anyMatch(p -> p.getIdentificationType().equals(type) && p.getIdPatient().equals(idPatient));
    }
	
	/**Verifica si ya existe un paciente con el mismo email.
     * @param email correo electrónico a verificar
     * @return true si ya existe, false si no
     * */
	public boolean existsByEmail(String email) {
        return patients.stream()
                .anyMatch(p -> p.getEmail().equalsIgnoreCase(email));
    }
	
	/** Retorna la cantidad total de pacientes registrados.
     * @return número de pacientes en el sistema
     */
    public int count() {
        return patients.size();
    }
	
}
