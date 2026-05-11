package co.edu.uptc.clinic.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.enums.PriorityEnum;

/**
 * Nombre de la clase: Patient
 *
 * <p>Entidad que representa un paciente registrado en la clínica El Laguito.</p>
 *
 * <p><b>Responsabilidades:</b>La unicidad del paciente se define por la combinación de tipo e identificación,
 * y por el correo electrónico. El historial de medicamentos conserva el orden
 * de ingreso y no permite duplicados, usando un LinkedHashSet.</p>
 * 
 * @author Carlitos
 * @version 1.0
 * @since 09/05/2026
 */
public class Patient {
	
	private IdentificationTypeEnum identificationType;
    /**
     * Atributo que determina el id del paciente
     */
    private Long idPatient;
    /**
     * Atributo que determina el nombre del paciente
     */
    private String firstName;
    /**
     * Atributo que determina los apellidos del paciente
     */
    private String lastName;
    /**
     * Atributo que determina el email del paciente
     */
    private String email;
    /**
     * Atributo que determina la prioridad de atencion al paciente
     */
    private PriorityEnum priority;
    /**
     * Atributo que determina el historial medico del paciente
     */
    private Set<String> medicationHistory;
    
    
	/**
	 * Crea una nueva instancia de Patient.
	 *
     * @param identificationType tipo de identificación del paciente
     * @param idPatient número de identificación del paciente
     * @param firstName nombre del paciente
     * @param lastName apellidos del paciente
     * @param email correo electrónico del paciente
     * @param priority nivel de prioridad de atención
	 */
	public Patient(IdentificationTypeEnum identificationType, long idPatient, String firstName, String lastName,
			String email, PriorityEnum priority) {
		super();
		this.identificationType = identificationType;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.priority = priority;
		this.medicationHistory = new LinkedHashSet<String>();
	}
	
	/*gets y sets*/
	
	/**
	 * Método encargado de retornar el valor de identificationType.
	 *
	 * @return valor de identificationType
	 */
	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}

	/**
	 * Método encargado de establecer el valor de identificationType.
	 *
	 * @param identificationType nuevo valor de identificationType
	 */
	public void setIdentificationType(IdentificationTypeEnum identificationType) {
		this.identificationType = identificationType;
	}

	/**
	 * Método encargado de retornar el valor de idPatient.
	 *
	 * @return valor de idPatient
	 */
	public Long getIdPatient() {
		return idPatient;
	}

	/**
	 * Método encargado de establecer el valor de idPatient.
	 *
	 * @param idPatient nuevo valor de idPatient
	 */
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	/**
	 * Método encargado de retornar el valor de firstName.
	 *
	 * @return valor de firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Método encargado de establecer el valor de firstName.
	 *
	 * @param firstName nuevo valor de firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Método encargado de retornar el valor de lastName.
	 *
	 * @return valor de lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Método encargado de establecer el valor de lastName.
	 *
	 * @param lastName nuevo valor de lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Método encargado de retornar el valor de email.
	 *
	 * @return valor de email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método encargado de establecer el valor de email.
	 *
	 * @param email nuevo valor de email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método encargado de retornar el valor de priority.
	 *
	 * @return valor de priority
	 */
	public PriorityEnum getPriority() {
		return priority;
	}
	
	/**
	 * Método encargado de retornar el valor de medicationHistory.
	 *
	 * @return valor de medicationHistory
	 */
	public Set<String> getMedicationHistory() {
		return medicationHistory;
	}

	/**
	 * Método encargado de establecer el valor de priority.
	 *
	 * @param priority nuevo valor de priority
	 */
	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}
	
	 /**
     * Agrega un medicamento al historial del paciente.
     * Si el medicamento ya existe, no se agrega de nuevo.
     *
     * @param medication nombre del medicamento a agregar
     * @return true si se agregó correctamente, false si ya existía
     */
	public boolean addMedication(String medication) {
		return medicationHistory.add(medication);
	}
	
	/**
     * Retorna el nombre completo del paciente (nombre + apellidos).
     *
     * @return nombre completo del paciente
     */
	public String getFullName() {
		return firstName+ " "+lastName;
	}
	
	/*Metodos*/
	
	
	/**
	 * <b>Descripción: </b> Método encargado de verificar si dos
	 * pacientes son iguales si tienen el mismo topi de identificaicon y el mismo ID <br>
	 * 
	 * @param obj objeto a comparar
     * @return true si representan al mismo paciente
	 */
	@Override
    public boolean equals(Object obj) {
    	/*this objeto actual se compara con obj y si apuntan al mismo lugar de memoria son iguales*/
    	if (this == obj) return true;
    	if (obj == null || getClass() != obj.getClass()) return false;
    	
    	Patient patient = (Patient) obj;
    	return this.idPatient.equals(patient.getIdPatient()) 
    			&& this.identificationType.equals(patient.getIdentificationType());
    }
    
	/**
	 * <b>Descripción: </b> Genera el código hash basado en el ID de identificación y el Tipo de identificacion. <br>
	 * 
	 * @return código hash del médico
	 */
    @Override
    public int hashCode() {
    	return Objects.hash(identificationType, idPatient);
    }

    /**
	 * <b>Descripción: </b> Representación en texto del paciente con sus datos principales.<br>
	 * 
     * @return String información del paciente en formato legible
	 */
	@Override
	public String toString() {
		return "Patient [identificationType=" + identificationType.getNameType() 
				+ ", idPatient=" + idPatient 
				+ ", firstName=" + firstName 
				+ ", lastName="  + lastName 
				+ ", email="     + email 
				+ ", priority="  + priority
				+ ", medicationHistory=" + medicationHistory + "]";
	}
    
    
    
    
}
