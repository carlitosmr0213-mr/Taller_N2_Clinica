package co.edu.uptc.clinic.service;

import java.util.Optional;
import java.util.Set;

import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.repository.PatientRepository;

/**
 * Nombre de la clase: PatientService
 *
 * <p>Servicio que implementa la lógica de negocio relacionada con los pacientes.</p>
 *
 * <p><b>Responsabilidades:</b>Actúa como intermediario entre la capa de presentación y el repositorio,
 * aplicando las reglas de unicidad y validación del sistema.</p>
 *
 * @author Carlitos
 * @version 1.0
 * @since 09/05/2026
 */
public class PatientService {

    /** Repositorio de pacientes con el que interactúa el servicio */

	private PatientRepository patientRepository;

	/**
     * Constructor que recibe el repositorio de pacientes.
     *
     * @param patientRepository repositorio de pacientes a usar
     */
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	
	/**
	 * <b>Descripción: </b> Registra un nuevo paciente en el sistema.
     * Valida que no exista duplicado por identificación ni por email. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param patient paciente a registrar
	 * @return boolean true si fue registrado, false si ya existía
	 */
	public boolean registerPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	/**
	 * <b>Descripción: </b>Agrega un medicamento al historial de un paciente identificado.
     * Si el medicamento ya existe en el historial, no se agrega de nuevo. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param type tipo de identificación del paciente
	 * @param idPatient número de identificación del paciente
	 * @param medication nombre del medicamento a agregar
	 * @return boolean true si se agregó el medicamento, false si ya existía o no se encontró el paciente
	 */
	public boolean addMedicationToPatient(IdentificationTypeEnum type, Long idPatient, String medication) {
		Optional<Patient> found = patientRepository.findByIdentificaion(type, idPatient);
		if (found.isEmpty()) {
			return false;	
		}
		return found.get().addMedication(medication);
	}
	
	/**
	 * <b>Descripción: </b> Busca un paciente por tipo e ID de identificación.<br>
	 * 
	 * @author Carlitos
	 *
	 * @param type tipo de identificación
	 * @param idPatient número de identificación
	 * @return OptionalPatient con el paciente si existe
	 */
	public Optional<Patient> findPatient(IdentificationTypeEnum type, Long idPatient){
		return patientRepository.findByIdentificaion(type, idPatient);
	}
	
	/**
	 * <b>Descripción: </b> Retorna todos los pacientes registrados en el sistema. <br>
	 * 
	 * @author Carlitos
	 *
	 * @return SetPatient conjunto con todos los pacientes
	 */
	public Set<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	/**
	 * <b>Descripción: </b> Verifica si existe un paciente con la identificación dada. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param type tipo de identificación
	 * @param idPatient número de identificación
	 * @return boolean true si el paciente existe
	 */
	public boolean patientExist(IdentificationTypeEnum type, Long idPatient) {
		return patientRepository.existsByIdentification(type, idPatient);
	}
	
	/**
	 * <b>Descripción: </b> Retorna el total de pacientes registrados. <br>
	 * 
	 * @author Carlitos
	 *
	 * @return int número de pacientes
	 */
	public int getTotalPatients(){
		return patientRepository.count();
	}
	
}
