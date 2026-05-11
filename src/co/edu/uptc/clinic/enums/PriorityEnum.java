package co.edu.uptc.clinic.enums;

/**
 * Nombre de la clase: PriorityEnum
 *
 * <p> Enumeración que representa los niveles de prioridad de atención
 * para los pacientes en la clínica El Laguito.</p>
 *
 * <p><b>Responsabilidades:</b>Los valores numéricos permiten comparar prioridades fácilmente.
 * @author Carlitos
 * @version 1.0
 * @since 11/05/2026
 */
public enum PriorityEnum {
	
	LOW(0, "Baja"), MEDIUM(1, "Media"),HIGH(2, "Alta"),CRITICAL(3, "Crítica");
	
	/**
	 * Atributo que determina el nivel de prioridad
	 */
	private int level;
	/**
	 * Atributo que determina el nombre legible del nivel de prioridad
	 */
	private String priorityName;
	
	/**
	 * Crea una nueva instancia de PriorityEnum.
	 *
     * @param level       nivel numérico de prioridad
     * @param displayName nombre en español de la prioridad
	 */
	private PriorityEnum(int level, String priorityName) {
		this.level = level;
		this.priorityName = priorityName;
	}

	/**
	 * Método encargado de retornar el valor de level.
	 *
	 * @return valor de level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Método encargado de retornar el valor de priorityName.
	 *
	 * @return valor de priorityName
	 */
	public String getPriorityName() {
		return priorityName;
	}

	
	
	
}
