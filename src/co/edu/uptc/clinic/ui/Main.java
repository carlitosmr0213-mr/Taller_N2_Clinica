package co.edu.uptc.clinic.ui;

/**
 * Nombre de la clase: Main
 *
 * <p>Clase principal que inicia la ejecución del sistema de gestión
 * de la clínica El Laguito.</p>
 *
 * <p><b>Responsabilidades:</b></p>
 * <ul>
 *   <li>[Responsabilidad 1] Registrar pacientes con unicidad por identificación y email</li>
 *   <li>[Responsabilidad 2] Registrar personal médico con unicidad por identificación</li>
 *   <li>[Responsabilidad 3] Gestionar el historial de medicamentos de cada paciente</li>
 *   <li>[Responsabilidad 4] Registrar y ver la agenda de citas médicas</li>
 *   <li>[Responsabilidad 5] Ver la cola de atención ordenada por hora y prioridad</li>
 *   <li>[Responsabilidad 6] Generar reportes de médicos por experiencia</li>
 * </ul>
 *
 *
 * @author Carlitos
 * @version 1.0
 * @since 11/05/2026
 */
public class Main {

	/**
	 * <b>Descripción: </b>Punto de entrada principal del sistema. <br>
	 * 
	 * @author Carlitos
	 *
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		
		MainManu menu= new MainManu();
		menu.star();
		
	}

}
