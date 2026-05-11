package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;

/**
 * Nombre de la clase: DoctorRepository
 *
 * <p>Repositorio encargado del almacenamiento y acceso a los datos de médicos.</p>
 *
 * <p><b>Responsabilidades:</b>Garantiza la unicidad por tipo + número de identificación.
 * Utiliza un HashSet para evitar duplicados de forma eficiente.</p>
 *
 * @author Carlitos
 * @version 1.0
 * @since 09/05/2026
 */
public class DoctorRepository {
	
	/**
     * Conjunto de médicos registrados en el sistema.
     * HashSet garantiza que no haya duplicados según equals/hashCode de Doctor.
     */
	private Set<Doctor> doctors;

	/**
     * Constructor que inicializa el repositorio vacío.
     */
	public DoctorRepository() {
		this.doctors = new HashSet<>();
	}
	
	/**
	 * <b>Descripción: </b> Retorna todos los médicos registrados en el sistema.<br>
	 * 
	 * @author Carlitos
	 * @return SetDoctor conjunto de todos los médicos
	 */
	public Set<Doctor> finAll(){
		return doctors;
	}
	
	/**
	 * <b>Descripción: </b>Registra un nuevo médico en el sistema.
     * Verifica que no exista otro con la misma identificación. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param doctor médico a registrar
	 * @return boolean true si fue registrado correctamente, false si ya existía un duplicado
	 */
	public boolean save(Doctor doctor) {
		if(existByIdentification(doctor.getIdentificationType(), doctor.getMedicalId())) {
			return false;
		}
		return doctors.add(doctor);
	}
	
	/**
	 * <b>Descripción: </b> Busca un médico por tipo e ID de identificación.<br>
	 * 
	 * @author Carlitos
	 *
	 * @param type tipo de identificación
	 * @param medicalId número de identificación médica
	 * @return OptionalDoctor con el médico si existe, vacío si no
	 */
	public Optional<Doctor> findByIdentification(IdentificationTypeEnum type, Long medicalId){
		return doctors.stream().filter(d -> d.getIdentificationType().equals(type) && d.getMedicalId().equals(medicalId))
				.findFirst();
	}
	
	/**
	 * <b>Descripción: </b> Verifica si ya existe un médico con la misma identificación. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param type tipo de identificación
	 * @param medicalId número de identificación médica
	 * @return boolean true si ya existe, false si no
	 */
	public boolean existByIdentification(IdentificationTypeEnum type, Long medicalId) {
		return doctors.stream()
				.anyMatch(d -> d.getIdentificationType().equals(type) && d.getMedicalId().equals(medicalId));
	}
	
	/**
	 * <b>Descripción: </b> Retorna la cantidad total de médicos registrados.<br>
	 * 
	 * @author Carlitos
	 * @return int número de médicos en el sistema
	 */
	public int count() {
		return doctors.size();
	}
	
}
