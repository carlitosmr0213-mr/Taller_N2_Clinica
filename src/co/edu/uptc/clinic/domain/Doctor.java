package co.edu.uptc.clinic.domain;

import java.util.Objects;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;

/**
 * Nombre de la clase: Doctor
 *
 * <p>Entidad que representa un médico registrado en la clínica El Laguito.
 * La unicidad del médico se define por la combinación de tipo e ID de identificación.</p>
 *
 * <p><b>Notas:</b> Implementa {@link Comparable} para definir el orden natural de los médicos:
 * primero por años de experiencia ascendente y, en empate, por nombre completo ascendente.</p>
 *
 * @author Carlitos
 * @version 1.0
 * @since 09/05/2026
 */
public class Doctor implements Comparable<Doctor>{
	
    /**
     * Atributo que determina el tipo de identificación del médico (CC, TI, CE, PA) */
    private IdentificationTypeEnum identificationType;
    /**
     * Atributo que determina el número de identificación médica del doctor (único en el sistema) */
    private Long medicalId;
    /**
     * Atributo que determina el nombre del médico */
    private String firstName;
    /**
     * Atributo que determina los apellidos del medico
     */
    private String lastName;
    /**
     * Atributo que determina la especialidad del medico*/
    private String specialty;
    /**
     * Atributo que determina los años de experiencia*/
    private int yearsOfExperience;
    
	/**
	 * Crea una nueva instancia de Doctor.
     *
     * @param identificationType tipo de identificación del médico
     * @param medicalId número de identificación médica
     * @param firstName nombre del médico
     * @param lastName apellidos del médico
     * @param specialty especialidad del médico
     * @param yearsOfExperience años de experiencia
	 */
	public Doctor(IdentificationTypeEnum identificationType, Long medicalId, String firstName, String lastName,
			String specialty, int yearsOfExperience) {
		super();
		this.identificationType = identificationType;
		this.medicalId = medicalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.yearsOfExperience = yearsOfExperience;
	}


	/*metodos*/
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
	 * Método encargado de retornar el valor de medicalId.
	 *
	 * @return valor de medicalId
	 */
	public Long getMedicalId() {
		return medicalId;
	}

	/**
	 * Método encargado de establecer el valor de medicalId.
	 *
	 * @param medicalId nuevo valor de medicalId
	 */
	public void setMedicalId(Long medicalId) {
		this.medicalId = medicalId;
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
	 * Método encargado de retornar el valor de specialty.
	 *
	 * @return valor de specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * Método encargado de establecer el valor de specialty.
	 *
	 * @param specialty nuevo valor de specialty
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	/**
	 * Método encargado de retornar el valor de yearsOfExperience.
	 *
	 * @return valor de yearsOfExperience
	 */
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	/**
	 * Método encargado de establecer el valor de yearsOfExperience.
	 *
	 * @param yearsOfExperience nuevo valor de yearsOfExperience
	 */
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}


	/**
	 * <b>Descripción: </b> Método encargado de retornar el nombre completo del médico (nombre + apellidos). <br>
	 * 
	 * @return String nombre completo del médico
	 */
	public String getFullName() {
		return firstName +" "+ lastName;
	}
	
	/**
	 * <b>Descripción: </b> Método encargado de verificar si dos
	 * médicos son iguales si tienen el mismo tipo e ID de identificación.. <br>
	 * 
	 * @param obj objeto a comparar
     * @return true si representan al mismo médicoo
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Doctor doctor = (Doctor) obj;
		return this.medicalId.equals(doctor.getMedicalId())
				&& this.identificationType.equals(doctor.getIdentificationType());
	}
	
	/**
	 * <b>Descripción: </b> Genera el código hash basado en tipo e ID de identificación. <br>
	 * 
	 * @return código hash del médico
	 */
	@Override
	public int hashCode() {
		return Objects.hash(identificationType,medicalId);
	}
	
	/**
	 * <b>Descripción: </b> Representación en texto del médico con sus datos principales.<br>
	 * 
     * @return String información del médico en formato legible
	 */
	@Override
	public String toString() {
		return "Doctor [identificationType=" + identificationType 
				+ ", medicalId=" + medicalId 
				+ ", firstName=" + firstName 
				+ ", lastName="  + lastName 
				+ ", specialty=" + specialty 
				+ ", yearsOfExperience=" + yearsOfExperience + "]";
	}

	/**
	 * <b>Descripción: </b> Método encargado de definir el orden natural de los médicos para el reporte del director.
     * Criterio 1: años de experiencia de forma ascendente (menos experiencia primero).
     * Criterio 2: si coinciden los años, ordena por nombre completo de forma ascendente (A-Z).
     *
     * @param o el otro médico con el que se compara
	 * @return negativo si this va antes, positivo si va después, 0 si son equivalentes <br>
	 */
	@Override
	public int compareTo(Doctor o) {
		int experienceComparison = Integer.compare(this.yearsOfExperience, o.yearsOfExperience);
		if (experienceComparison !=0) {
			return experienceComparison;
		}
		return this.getFullName().compareTo(o.getFullName());
	}
	
    
}
