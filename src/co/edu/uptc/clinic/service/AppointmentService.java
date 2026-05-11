package co.edu.uptc.clinic.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.domain.MedicalAppointment;
import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.repository.AppointmentRepository;

/**
 * Nombre de la clase: AppointmentService
 *
 * <p>Servicio que implementa la lógica de negocio relacionada con las citas médicas.</p>
 *
 * <p><b>Responsabilidades:</b>Gestiona el registro de citas y la generación de la cola de atención,
 * ordenada por hora y por prioridad del paciente.</p>
 * 
 * @author Carlitos
 * @version 1.0
 * @since 11/05/2026
 */
public class AppointmentService {
	
    /** Repositorio de citas médicas con el que interactúa el servicio */
	private AppointmentRepository appointmentRepository;
    /** Servicio de pacientes para validar que el paciente exista */
	private PatientService patientService;
    /** Servicio de médicos para validar que el médico exista */
	private DoctorService doctorService;
	
	/**
	 * Crea una nueva instancia de AppointmentService.
	 *
	 * @param appointmentRepository repositorio de citas
     * @param patientService servicio de pacientes para validaciones
     * @param doctorService servicio de médicos para validaciones
     */
	public AppointmentService(AppointmentRepository appointmentRepository, PatientService patientService,
			DoctorService doctorService) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.patientService = patientService;
		this.doctorService = doctorService;
	}
	
	/**
	 * <b>Descripción: </b> Registra una nueva cita médica en el sistema.
     * Valida que el ID sea único, que el paciente exista y que el médico exista. <br>
	 * 
	 * @author Carlitos
	 *
     * @param appointment cita médica a registrar
     * @param patientIdtype tipo de identificación del paciente
     * @param patientId número de identificación del paciente
     * @param doctorIdType tipo de identificación del médico
     * @param medicalID número de identificación del médico
     * @return String resultado del registro con mensaje descriptivo
     */
	public String registerAppointment(MedicalAppointment appointment, IdentificationTypeEnum patientIdtype,
			Long patientId, IdentificationTypeEnum doctorIdType, Long medicalID) {
		if(appointmentRepository.existById(appointment.getIdMedicalAppointment())) {
			return "ERROR: YA EXISTE UNA CITA CON EL ID:"+appointment.getIdMedicalAppointment();
		}
		
		Optional<Patient> patient = patientService.findPatient(patientIdtype, patientId);
		
		if(patient.isEmpty()) {
			return "ERROR: No existe un paciente con esa indentificación";
		}
		
		Optional<Doctor> doctor = doctorService.findDoctor(doctorIdType, medicalID);
		
		if(doctor.isEmpty()) {
			return "ERROR: No existe un doctor con esa identificación";
		}
		appointment.setPatient(patient.get());
		appointment.setDoctor(doctor.get());
		
		boolean saved = appointmentRepository.save(appointment);
		
		if(saved) {
			return "Realizado";
		}
		
		return "ERROR: No se pudo registrar la cita";
	}
	
	/**
	 * <b>Descripción: </b> Genera la cola de atención usando el orden natural de {@link MedicalAppointment}.
     * Las citas se ordenan por hora ascendente y, en empate, por prioridad descendente.
     * El orden lo define el método {@code compareTo} de la clase MedicalAppointment. <br>
	 * 
	 * @author Carlitos
	 *
	 * @return ListMedicalAppointment lista de citas ordenadas para la cola de atención
	 */
	public List<MedicalAppointment> getAttentionQueue() {
        return appointmentRepository.findAll().stream()
                .sorted()
                .collect(Collectors.toList());
	}
	
	/**
	 * <b>Descripción: </b> Retorna todas las citas médicas registradas.<br>
	 * 
	 * @author Carlitos
	 *
	 * @return SetMedicalAppointment conjunto con todas las citas
	 */
	public Set<MedicalAppointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
	
    /**
     * <b>Descripción: </b> Retorna el total de citas registradas<br>
     * 
     * @author Carlitos
     *
     * @return int número de citas
     */
    public int getTotalAppointments() {
        return appointmentRepository.count();
    }
}	
	
