package co.edu.uptc.clinic.enums;

/**
 * Nombre de la clase: IdentificationTypeEnum
 *
 * <p>Clase tip</p>
 *
 * <p><b>Responsabilidades:</b> * Enumeración que representa los tipos de identificación válidos
 * para pacientes y médicos en el sistema de la clínica El Laguito.</p>
 * 
 * @author Carlitos
 * @version 1.0
 * @since 09/05/2026
 */
public enum IdentificationTypeEnum {
	
	CC("Cédula de ciudadanía"), TI("Tarjeta de identidad"), CE("Cédula de extranjería"), PA("Pasaporte");
	
	/**
	 * Atributo que determina  el nombre legible del tipo de identificacion
	 */
	private String nameType;

	/**
	 * Crea una nueva instancia de IdentificationTypeEnum.
	 *
	 * @param nameType Parámetro que determina el nombre legible del tipo de identificaion
	 */
	private IdentificationTypeEnum(String nameType) {
		this.nameType = nameType;
	}

	/**
	 * Método encargado de retornar el valor de nameType.
	 *
	 * @return valor de nameType
	 */
	public String getNameType() {
		return nameType;
	}

	
	

}
