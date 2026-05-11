package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;

/**
 * Nombre de la clase: PatientRepository
 *
 * <p>Repositorio encargado del almacenamiento y acceso a los datos de pacientes.</p>
 *
 * <p><b>Responsabilidades:</b>Garantiza la unicidad por tipo + número de identificación y por email.
 * Utiliza un HashSet para evitar duplicados de forma eficiente.</p>
 * @author Carlitos
 * @version 1.0
 * @since 09/05/2026
 */
public class PatientRepository {
	
	/**
     * Conjunto de pacientes registrados en el sistema.
     * HashSet garantiza que no haya duplicados según equals/hashCode de Patient.
     */
	private Set<Patient> patients;

	/**
     * Constructor que inicializa el repositorio vacío.
     */
	public PatientRepository() {
		this.patients = new HashSet<Patient>();
	}
	
	/**
	 * <b>Descripción: </b> Registra un nuevo paciente en el sistema.
     * Verifica que no exista otro con la misma identificación ni el mismo email.<br>
	 * 
	 * @author Carlitos
	 *
	 * @param patient paciente a registrar
	 * @return boolean true si fue registrado correctamente, false si ya existía un duplicado
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
	
	
	/**
	 * <b>Descripción: </b> Retorna todos los pacientes registrados en el sistema. <br>
	 * 
	 * @author Carlitos
	 *
	 * @return SetPatient conjunto de todos los pacientes
	 */
	public Set<Patient> findAll(){
		return this.patients;
	}
	
	/**
	 * <b>Descripción: </b> Busca un paciente por tipo e ID de identificación. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param type tipo de identificación
	 * @param idPatient número de identificación
	 * @return OptionalPatient con el paciente si existe, vacío si no
	 */
	public Optional<Patient> findByIdentificaion(IdentificationTypeEnum type,Long idPatient) {
		return this.patients.stream().filter(p -> p.getIdentificationType().equals(type) && p.getIdPatient().equals(idPatient))
		.findFirst();
	}
	
	/**
	 * <b>Descripción: </b> Busca un paciente por su correo electrónico.<br>
	 * 
	 * @author Carlitos
	 *
	 * @param email correo electrónico a buscar
	 * @return OptionalPatient con el paciente si existe, vacío si no
	 */
	public Optional<Patient> findByEmail(String email) {
		return this.patients.stream().filter(p -> p.getEmail().equals(email))
				.findFirst();
	}
	
	/**
	 * <b>Descripción: </b> Verifica si ya existe un paciente con la misma identificación. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param type tipo de identificación
	 * @param idPatient número de identificación
	 * @return boolean true si ya existe, false si no
	 */
	public boolean existsByIdentification(IdentificationTypeEnum type, Long idPatient) {
        return patients.stream()
                .anyMatch(p -> p.getIdentificationType().equals(type) && p.getIdPatient().equals(idPatient));
    }

	/**
	 * <b>Descripción: </b> Verifica si ya existe un paciente con el mismo email.<br>
	 * 
	 * @author Carlitos
	 *
	 * @param email correo electrónico a verificar
	 * @return boolean true si ya existe, false si no
	 */
	public boolean existsByEmail(String email) {
        return patients.stream()
                .anyMatch(p -> p.getEmail().equalsIgnoreCase(email));
    }
	

    /**
     * <b>Descripción: </b> Retorna la cantidad total de pacientes registrados. <br>
     * 
     * @author Carlitos
     *
     * @return int número de pacientes en el sistema
     */
    public int count() {
        return patients.size();
    }
	
}
