package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import co.edu.uptc.clinic.domain.MedicalAppointment;

/**
 * Nombre de la clase: AppointmentRepository
 *
 * <p>Repositorio encargado del almacenamiento y acceso a las citas médicas.</p>
 *
 * <p><b>Responsabilidades:</b>Garantiza la unicidad por identificador de cita.
 * Utiliza un HashSet para evitar duplicados de forma eficiente.</p>
 *
 * @author Carlitos
 * @version 1.0
 * @since 09/05/2026
 */
public class AppointmentRepository {
	
	/**
	 * Atributo que determina el conjunto de citas médicas registradas en el sistema.
     * HashSet garantiza que no haya duplicados según equals/hashCode de MedicalAppointment.
	 */
	private Set<MedicalAppointment> appointments;

	/**
     * Constructor que inicializa el repositorio vacío.
	 */
	public AppointmentRepository() {
		this.appointments = new HashSet<>();
	}
	
	/**
	 * <b>Descripción: </b>Retorna todas las citas médicas registradas en el sistema. <br>
	 * 
	 * @author Carlitos
	 *
	 * @return SetMedicalAppointment conjunto de todas las citas médicas
	 */
	public Set<MedicalAppointment> findAll() {
        return appointments;
    }
	
	/**
	 * <b>Descripción: </b>Registra una nueva cita médica en el sistema.
     * Verifica que no exista otra cita con el mismo identificador. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param appointment cita médica a registrar
	 * @return boolean  true si fue registrada correctamente, false si ya existía un duplicado
	 */
	public boolean save(MedicalAppointment appointment) {
		if(existById(appointment.getIdMedicalAppointment())) {
			return false;
		}
		return appointments.add(appointment);
	}
	
	/**
	 * <b>Descripción: </b>Busca una cita médica por su identificador único.<br>
	 * 
	 * @author Carlitos
	 *
	 * @param id identificador de la cita
	 * @return OptionalMedicalAppointment con la cita si existe, vacío si no
	 */
	public Optional<MedicalAppointment> findById(String id){
		return appointments.stream().filter(a -> a.getIdMedicalAppointment().equals(id))
				.findFirst();
	}
	
	
	/**
	 * <b>Descripción: </b>Verifica si ya existe una cita con el mismo identificador. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param id  identificador a verificar
	 * @return boolean true si ya existe, false si no
	 */
	public boolean existById(String id) {
		return appointments.stream().anyMatch(a -> a.getIdMedicalAppointment().equals(id));
	}
	
	
	/**
	 * <b>Descripción: </b> Retorna la cantidad total de citas registradas. <br>
	 * 
	 * @author Carlitos
	 *
	 * @return int número de citas en el sistema
	 */
	public int count() {
		return appointments.size();
	}
	
	
}
