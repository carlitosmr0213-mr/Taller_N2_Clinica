package co.edu.uptc.clinic.domain;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Nombre de la clase: MedicalAppointment
 *
 * <p>Entidad que representa una cita médica en la clínica El Laguito.</p>
 *
 * <p><b>Responsabilidades:</b>Asocia a un paciente con un médico en un horario específico.
 * Implementa {@link Comparable} para definir el orden natural de las citas:
 * primero por hora ascendente y, en caso de empate, por prioridad descendente.</p>
 *
 * @author Carlitos
 * @version 1.0
 * @since 09/05/2026
 */
public class MedicalAppointment implements Comparable<MedicalAppointment>{
	
    /**
     * Atributo que determina el id de la cita*/
    private String idMedicalAppointment;
    /**
     * Atributo que determina la hora de la cita */
    private LocalTime timeAppointment;
    /**
     * Atributo que determina el paciente asignado*/
    private Patient patient;
    /**
     * Atributo que determina el medico asignado*/
    private Doctor doctor;
    
	/**
	 * Crea una nueva instancia de MedicalAppointment.
	 *
	 * @param idMedicalAppointment identificador único de la cita
     * @param timeAppointment hora de la cita
     * @param patient paciente de la cita
     * @param doctor médico de la cita
	 */
	public MedicalAppointment(String idMedicalAppointment, LocalTime timeAppointment, Patient patient, Doctor doctor) {
		super();
		this.idMedicalAppointment = idMedicalAppointment;
		this.timeAppointment = timeAppointment;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	/**
	 * Método encargado de retornar el valor de idMedicalAppointment.
	 *
	 * @return valor de idMedicalAppointment
	 */
	public String getIdMedicalAppointment() {
		return idMedicalAppointment;
	}

	/**
	 * Método encargado de establecer el valor de idMedicalAppointment.
	 *
	 * @param idMedicalAppointment nuevo valor de idMedicalAppointment
	 */
	public void setIdMedicalAppointment(String idMedicalAppointment) {
		this.idMedicalAppointment = idMedicalAppointment;
	}

	/**
	 * Método encargado de retornar el valor de timeAppointment.
	 *
	 * @return valor de timeAppointment
	 */
	public LocalTime getTimeAppointment() {
		return timeAppointment;
	}

	/**
	 * Método encargado de establecer el valor de timeAppointment.
	 *
	 * @param timeAppointment nuevo valor de timeAppointment
	 */
	public void setTimeAppointment(LocalTime timeAppointment) {
		this.timeAppointment = timeAppointment;
	}

	/**
	 * Método encargado de retornar el valor de patient.
	 *
	 * @return valor de patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Método encargado de establecer el valor de patient.
	 *
	 * @param patient nuevo valor de patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * Método encargado de retornar el valor de doctor.
	 *
	 * @return valor de doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * Método encargado de establecer el valor de doctor.
	 *
	 * @param doctor nuevo valor de doctor
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * <b>Descripción: </b> Método encargado de verificar si dos
	 * citas son iguales si tienen el mismo ID <br>
	 * 
	 * @author Carlitos
	 * @param obj objeto a comparar
     * @return true si representan al mismo médicoo
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj ==null || getClass() != obj.getClass()) return false;	
		MedicalAppointment appointment= (MedicalAppointment) obj;
		return Objects.equals(idMedicalAppointment, appointment.getIdMedicalAppointment());
	}
	
	/**
	 * <b>Descripción: </b> Genera el código hash basado en el ID de identificación. <br>
	 * 
	 * @author Carlitos
	 * @return código hash del médico
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idMedicalAppointment);
	}

	/**
	 * <b>Descripción: </b> Representación en texto de la cita medica con sus datos principales.<br>
	 * 
	 * @author Carlitos
     * @return String información de la cita en formato legible
	 */
	@Override
	public String toString() {
		return "MedicalAppointmet [idMedicalAppointment=" + idMedicalAppointment 
				+ ", timeAppointment="	+ timeAppointment 
				+ ", patient=" + patient 
				+ ", doctor="  + doctor + "]";
	}

	/**
	 * <b>Descripción: </b> Método encargado de definir el orden natural de las citas medicas para la cola de atencion
	 * Criterio 1: hora de la cita de forma ascendente (más temprano primero).
     * Criterio 2: si la hora es igual, prioridad del paciente de forma descendente
     * (CRITICAL primero, LOW de último).
     * 
     * @param o el otro médico con el que se compara
	 * @author Carlitos
	 * @return negativo si this va antes, positivo si va después, 0 si son equivalentes <br>
	 */
	@Override
	public int compareTo(MedicalAppointment o) {
		int timeComparison = this.timeAppointment.compareTo(o.timeAppointment);
		if(timeComparison !=0) {
			return timeComparison;
		}
		return Integer.compare(o.patient.getPriority().getLevel(), this.patient.getPriority().getLevel());
				
	}
	
	
}
