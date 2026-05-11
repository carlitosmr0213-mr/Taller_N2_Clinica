	package co.edu.uptc.clinic.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.repository.DoctorRepository;

/**
 * Nombre de la clase: DoctorService
 *
 * <p> Servicio que implementa la lógica de negocio relacionada con los médicos.</p>
 *
 * <p><b>Responsabilidades:</b> Actúa como intermediario entre la capa de presentación y el repositorio,
 * aplicando las reglas de unicidad y los reportes de experiencia.</p>
 * 
 * @author Carlitos
 * @version 1.0
 * @since 09/05/2026
 */
public class DoctorService {
	
    /** Repositorio de médicos con el que interactúa el servicio */
	private DoctorRepository doctorRepository;

	/**
     * Constructor que recibe el repositorio de médicos.
     *
     * @param doctorRepository repositorio de médicos a usar
     */
	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	/**
	 * <b>Descripción: </b> Registra un nuevo médico en el sistema.
     * Valida que no exista duplicado por identificación. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param doctor médico a registrar
	 * @return boolean true si fue registrado, false si ya existía
	 */
	public boolean registerDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	/**
	 * <b>Descripción: </b> Busca un médico por tipo e ID de identificación. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param type tipo de identificación
	 * @param medicalId número de identificación médica
	 * @return OptionalDoctor con el médico si existe
	 */
	public Optional<Doctor> findDoctor(IdentificationTypeEnum type, Long medicalId){
		return doctorRepository.findByIdentification(type, medicalId);
	}
	
	/**
	 * <b>Descripción: </b>  Retorna todos los médicos registrados en el sistema.<br>
	 * 
	 * @author Carlitos
	 * 
	 * @return SetDoctor conjunto con todos los médicos
	 */
	public Set<Doctor> getAllDoctors(){
		return doctorRepository.finAll();
	}	
	
	/**
	 * <b>Descripción: </b> Verifica si existe un médico con la identificación dada. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param type tipo de identificación
	 * @param medicalId número de identificación médica
	 * @return boolean true si el médico existe
	 */
	public boolean doctorExists(IdentificationTypeEnum type, Long medicalId) {
		return doctorRepository.existByIdentification(type, medicalId);
	}
	
	/**
	 * <b>Descripción: </b> Genera el reporte de médicos usando el orden natural de {@link Doctor}.
     * Los médicos se ordenan por experiencia ascendente y, en empate, por nombre completo A-Z.
     * El orden lo define el método {@code compareTo} de la clase Doctor. <br>
	 * 
	 * @author Carlitos
	 *
	 * @return ListDoctor lista de médicos ordenada por experiencia y nombre completo
	 */
	public List<Doctor> getDoctorSortedByExperience(){
		return doctorRepository.finAll().stream().sorted().collect(Collectors.toList());
	}
	
	/**
	 * <b>Descripción: </b> Retorna el total de médicos registrados.<br>
	 * 
	 * @author Carlitos
	 *
	 * @return int número de médicos
	 */
	public int getTotalDoctors() {
		return doctorRepository.count();
	}
	
	
}
