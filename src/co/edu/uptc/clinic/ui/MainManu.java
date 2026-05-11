package co.edu.uptc.clinic.ui;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.domain.MedicalAppointment;
import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.enums.PriorityEnum;
import co.edu.uptc.clinic.repository.AppointmentRepository;
import co.edu.uptc.clinic.repository.DoctorRepository;
import co.edu.uptc.clinic.repository.PatientRepository;
import co.edu.uptc.clinic.service.AppointmentService;
import co.edu.uptc.clinic.service.DoctorService;
import co.edu.uptc.clinic.service.PatientService;

/**
 * Nombre de la clase: MainManuJ
 *
 * <p>Interfaz de usuario principal del sistema de la clínica El Laguito.
 * </p>
 * <p><b>Responsabilidades:</b>Gestiona la interacción con el usuario mediante ventanas JOptionPane
 * y delega la lógica a las capas de servicio correspondientes.</p>
 * @author Carlitos
 * @version 1.0
 * @since 6/05/2026
 */
public class MainManu{

		/**Atributo para servicio de pacientes*/
		private PatientService patientService;
		/**Atributo para servicio de doctores*/
		private DoctorService doctorService;
		/**Atributo para servicio de citas medicas*/
		private AppointmentService appointmentService;
		/**
		 * Constructor que inicializa todos los repositorios y servicios del sistema.
		 *
		 */
		public MainManu() {
			PatientRepository patientRepository = new PatientRepository();
		    DoctorRepository doctorRepository = new DoctorRepository();
		    AppointmentRepository appointmentRepository = new AppointmentRepository();
		    
			this.patientService = new PatientService(patientRepository);
			this.doctorService = new DoctorService(doctorRepository);
			this.appointmentService = new AppointmentService(appointmentRepository, patientService, doctorService);
		}
		
		/**
		 * <b>Descripción: </b> Método encargado de iniciar el ciclo principal del menú del sistema.
     * Muestra opciones hasta que el usuario decida salir. ... <br>
		 * 
		 *
		 */
		public void star() {
			boolean running = true;
			
			while(running) {
				String[] options = {
						"1. Registrar Paciente",
	                    "2. Registrar Médico",
	                    "3. Registrar Cita Médica",
	                    "4. Agregar Medicamento a Paciente",
	                    "5. Ver Cola de Atención",
	                    "6. Reporte de Médicos por Experiencia",
	                    "7. Ver Todos los Pacientes",
	                    "8. Salir"	
				};
				
				String selected = (String) JOptionPane.showInputDialog(null, 
						"Clínica El Laguito\nSeleccione una opción:", 
						"Menú Principal",
						JOptionPane.PLAIN_MESSAGE, 
						null, 
						options,
						options[0]);
				if(selected == null) {
					running = false;
					continue;
				}
				
				switch (selected) {
				case "1. Registrar Paciente" -> registerPatient();
				case "2. Registrar Médico" -> registerDoctor();
				case "3. Registrar Cita Médica" -> registerAppointment();
				case "4. Agregar Medicamento a Paciente" -> addMedication();
				case "5. Ver Cola de Atención" -> showAttentionQueue();
				case "6. Reporte de Médicos por Experiencia" -> showDoctorExperienceReport();
				case "7. Ver Todos los Pacientes" -> showAllPatients();
				case "8. Salir" -> running = false;
				}
			}
			JOptionPane.showMessageDialog(null, "Sistema cerrado.", "Salir", JOptionPane.INFORMATION_MESSAGE);
		}	
		
		// Métodos privados de cada opción del menú
	    /**
	     * <b>Descripción: </b> Método encargado de manejar el flujo de registro de un nuevo paciente.
	     * Solicita todos los datos al usuario y valida el ingreso. <br>
	     * 
	     * @author Carlitos
	     *
	     * @return void
	     * @throws Exception [Se ingresan letras donde deben ser numeros]
	     */
	    private void registerPatient() {
	        try {
	            IdentificationTypeEnum idType = selectIdentificationType("paciente");
	            if (idType == null) return;
	 
	            String idStr = JOptionPane.showInputDialog(null, "Número de identificación del paciente:","Registrar Paciente", JOptionPane.QUESTION_MESSAGE);
	            if (idStr == null || idStr.isBlank()) return;
	            Long idPatient = Long.parseLong(idStr.trim());
	            
	            String firstName = JOptionPane.showInputDialog(null, "Nombre del paciente","Registrar Paciente",JOptionPane.QUESTION_MESSAGE);
	            if (firstName == null || firstName.isBlank()) return;
	            
	            String lastName = JOptionPane.showInputDialog(null,"Apellidos del paciente","Registrar Paciente",JOptionPane.QUESTION_MESSAGE);
	            if(lastName == null || lastName.isBlank()) return;
	            
	            String email = JOptionPane.showInputDialog(null, "Correo electrónico del paciente:", "Registrar Paciente", JOptionPane.QUESTION_MESSAGE);
	            if (email == null || email.isBlank()) return;
	            
	            PriorityEnum priority = selectPriority();
	            if (priority == null) return;
	            
	            Patient patient = new Patient(idType, idPatient, firstName.trim(), lastName.trim(), email.trim(), priority);
	            boolean registered = patientService.registerPatient(patient);
	            
	            if(registered) {
	            	JOptionPane.showMessageDialog(null, "Paciente registrado exitosamente", "Exito",JOptionPane.INFORMATION_MESSAGE);
	            }else {
	            	JOptionPane.showMessageDialog(null, "No se pudo registrar: ya existe un paciente con esa identificación o ese email", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            }
	            
	        }catch (NumberFormatException e) {
	        	JOptionPane.showMessageDialog(null, "El número de identificación debe ser numérico.","Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    
			
	    /**
	     * <b>Descripción: </b> Método encargado de manejar el flujo de registro de un nuevo médico.
	     * Solicita todos los datos al usuario y valida el ingreso. <br>
	     * 
	     * @author Carlitos
	     *
	     * @return void
	     * @throws Exception [Se ingresan letras donde deben ser numeros]
	     */
	    private void registerDoctor() {
	        try {
	            IdentificationTypeEnum idType = selectIdentificationType("médico");
	            if (idType == null) return;
	 
	            String idStr = JOptionPane.showInputDialog(null, "Número de identificación del médico:", "Registrar Médico", JOptionPane.QUESTION_MESSAGE);
	            if (idStr == null || idStr.isBlank()) return;
	            long medicalId = Long.parseLong(idStr.trim());
	 
	            String firstName = JOptionPane.showInputDialog(null, "Nombre del médico:", "Registrar Médico", JOptionPane.QUESTION_MESSAGE);
	            if (firstName == null || firstName.isBlank()) return;
	 
	            String lastName = JOptionPane.showInputDialog(null, "Apellidos del médico:", "Registrar Médico", JOptionPane.QUESTION_MESSAGE);
	            if (lastName == null || lastName.isBlank()) return;
	 
	            String specialty = JOptionPane.showInputDialog(null, "Especialidad del médico:", "Registrar Médico", JOptionPane.QUESTION_MESSAGE);
	            if (specialty == null || specialty.isBlank()) return;
	 
	            String yearsStr = JOptionPane.showInputDialog(null, "Años de experiencia:", "Registrar Médico", JOptionPane.QUESTION_MESSAGE);
	            if (yearsStr == null || yearsStr.isBlank()) return;
	            int yearsOfExperience = Integer.parseInt(yearsStr.trim());
	 
	            Doctor doctor = new Doctor(idType, medicalId, firstName.trim(), lastName.trim(), specialty.trim(), yearsOfExperience);
	            boolean registered = doctorService.registerDoctor(doctor);
	 
	            if (registered) {
	                JOptionPane.showMessageDialog(null, "Médico registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "No se pudo registrar: ya existe un médico con esa identificación.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            }
	 
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Los valores numéricos ingresados no son válidos.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }  
	    
	    /**
	     * <b>Descripción: </b> Método encargado de manejar el flujo de registro de una nueva cita médica.
	     * Solicita el ID de la cita, hora, paciente y médico. <br>
	     * 
	     * @author Carlitos
	     *
	     * @return void
	     * @throws Exception [Se ingresan letras donde deben ser numeros]
	     * @throws Exception [Se ingresa la hora en un formato invalido]
	     */
	    private void registerAppointment() {
	        try {
	            String appointmentId = JOptionPane.showInputDialog(null, "ID de la cita médica:", "Registrar Cita", JOptionPane.QUESTION_MESSAGE);
	            if (appointmentId == null || appointmentId.isBlank()) return;
	 
	            String timeStr = JOptionPane.showInputDialog(null, "Hora de la cita (formato HH:MM, ejemplo: 09:30):", "Registrar Cita", JOptionPane.QUESTION_MESSAGE);
	            if (timeStr == null || timeStr.isBlank()) return;
	            LocalTime time = LocalTime.parse(timeStr.trim());
	 
	            JOptionPane.showMessageDialog(null, "Ahora ingrese los datos del PACIENTE:", "Cita - Paciente", JOptionPane.INFORMATION_MESSAGE);
	            IdentificationTypeEnum patientIdType = selectIdentificationType("paciente");
	            if (patientIdType == null) return;
	 
	            String patientIdStr = JOptionPane.showInputDialog(null, "Número de identificación del paciente:", "Cita - Paciente", JOptionPane.QUESTION_MESSAGE);
	            if (patientIdStr == null || patientIdStr.isBlank()) return;
	            long patientId = Long.parseLong(patientIdStr.trim());
	 
	            JOptionPane.showMessageDialog(null, "Ahora ingrese los datos del MÉDICO:", "Cita - Médico", JOptionPane.INFORMATION_MESSAGE);
	            IdentificationTypeEnum doctorIdType = selectIdentificationType("médico");
	            if (doctorIdType == null) return;
	 
	            String doctorIdStr = JOptionPane.showInputDialog(null, "Número de identificación del médico:", "Cita - Médico", JOptionPane.QUESTION_MESSAGE);
	            if (doctorIdStr == null || doctorIdStr.isBlank()) return;
	            long doctorId = Long.parseLong(doctorIdStr.trim());
	 
	            MedicalAppointment appointment = new MedicalAppointment(appointmentId.trim(), time, null, null);
	 
	            String result = appointmentService.registerAppointment(
	                    appointment, patientIdType, patientId, doctorIdType, doctorId
	            );
	 
	            if (result.equals("Realizado")) {
	                JOptionPane.showMessageDialog(null, "Cita médica registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, result, "Error", JOptionPane.ERROR_MESSAGE);
	            }
	 
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "El número de identificación debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
	        } catch (DateTimeParseException e) {
	            JOptionPane.showMessageDialog(null, "Formato de hora inválido. Use HH:MM (ej: 09:30).", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }	    
	    
	    /**
	     * <b>Descripción: </b> Método encargado de manejar el flujo para agregar un medicamento al historial de un paciente. <br>
	     * 
	     * @author Carlitos
	     *
	     * @return void
	     * @throws Exception [Se ingresan letras donde deben ser numeros]
	     */
	    private void addMedication() {
	        try {
	            IdentificationTypeEnum idType = selectIdentificationType("paciente");
	            if (idType == null) return;
	 
	            String idStr = JOptionPane.showInputDialog(null, "Número de identificación del paciente:", "Agregar Medicamento", JOptionPane.QUESTION_MESSAGE);
	            if (idStr == null || idStr.isBlank()) return;
	            long idPatient = Long.parseLong(idStr.trim());
	 
	            String medication = JOptionPane.showInputDialog(null, "Nombre del medicamento a agregar:", "Agregar Medicamento", JOptionPane.QUESTION_MESSAGE);
	            if (medication == null || medication.isBlank()) return;
	 
	            boolean added = patientService.addMedicationToPatient(idType, idPatient, medication.trim());
	 
	            if (added) {
	                JOptionPane.showMessageDialog(null, "Medicamento agregado al historial del paciente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "No se pudo agregar: el paciente no existe o el medicamento ya estaba registrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            }
	 
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "El número de identificación debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }   
	    
	    /**
	     * <b>Descripción: </b> Método encargado de Muestra la cola de atención ordenada por hora y luego por prioridad (mayor primero). <br>
	     * 
	     * @author Carlitos
	     *
	     * @return void
	     */
	    private void showAttentionQueue() {
	    	
	    	List<MedicalAppointment> queue = appointmentService.getAttentionQueue();
	    	
	    	if(queue.isEmpty()) {
	    		JOptionPane.showMessageDialog(null, "No hay citas registradas", "Orden de atención", JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	
	    	StringBuilder sb = new StringBuilder();
	        sb.append("========================================\n");
	        sb.append("          COLA DE ATENCIÓN\n");
	        sb.append("========================================\n\n");
	 
	        int position = 1;
	        for (MedicalAppointment appointment : queue) {
	            sb.append("Turno #").append(position++).append("\n");
	            sb.append("ID Cita   : ").append(appointment.getIdMedicalAppointment()).append("\n");
	            sb.append("Hora      : ").append(appointment.getTimeAppointment()).append("\n");
	            sb.append("Paciente  : ").append(appointment.getPatient().getFullName()).append("\n");
	            sb.append("Prioridad : ").append(appointment.getPatient().getPriority()).append("\n");
	            sb.append("Médico    : ").append(appointment.getDoctor().getFullName()).append("\n");
	            sb.append("Especialidad: ").append(appointment.getDoctor().getSpecialty()).append("\n");
	            sb.append("__________________________________________\n");
	        }
	 
	        JOptionPane.showMessageDialog(null, sb.toString(), "Cola de Atención", JOptionPane.PLAIN_MESSAGE);
	    }	    	
	    
	    /**
	     * <b>Descripción: </b> Método encargado de mostrar el reporte de médicos ordenado por experiencia ascendente.
	     * En caso de empate, ordena por nombre completo ascendente. <br>
	     * 
	     * @author Carlitos
	     *
	     * @return void
	     */
	    private void showDoctorExperienceReport() {
	        List<Doctor> doctors = doctorService.getDoctorSortedByExperience();
	 
	        if (doctors.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No hay médicos registrados en el sistema.", "Reporte Médicos", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	 
	        StringBuilder sb = new StringBuilder();
	        sb.append("========================================\n");
	        sb.append("    REPORTE: MÉDICOS POR EXPERIENCIA\n");
	        sb.append("========================================\n\n");
	 
	        int rank = 1;
	        for (Doctor doctor : doctors) {
	            sb.append("Pos #").append(rank++).append("\n");
	            sb.append("Nombre       : ").append(doctor.getFullName()).append("\n");
	            sb.append("  Especialidad : ").append(doctor.getSpecialty()).append("\n");
	            sb.append("  Experiencia  : ").append(doctor.getYearsOfExperience()).append(" años\n");
	            sb.append("  Identificación: ").append(doctor.getIdentificationType()).append(" ").append(doctor.getMedicalId()).append("\n");
	            sb.append("____________________________________\n");
	        }
	 
	        JOptionPane.showMessageDialog(null, sb.toString(), "Reporte por Experiencia", JOptionPane.PLAIN_MESSAGE);
	    }
	    	
	    /**
	     * <b>Descripción: </b> Método encargado de mostrar todos los pacientes registrados en el sistema con su historial de medicamentos. <br>
	     * 
	     * @author Carlitos
	     *
	     * @return void
	     */
	    private void showAllPatients() {
	        Set<Patient> patients = patientService.getAllPatients();
	 
	        if (patients.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No hay pacientes registrados en el sistema.", "Pacientes", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	 
	        StringBuilder sb = new StringBuilder();
	        sb.append("======================================\n");
	        sb.append("        LISTA DE PACIENTES\n");
	        sb.append("======================================\n\n");
	 
	        for (Patient patient : patients) {
	            sb.append("Nombre     : ").append(patient.getFullName()).append("\n");
	            sb.append("Tipo ID    : ").append(patient.getIdentificationType().getNameType()).append("\n");
	            sb.append("ID         : ").append(patient.getIdPatient()).append("\n");
	            sb.append("Email      : ").append(patient.getEmail()).append("\n");
	            sb.append("Prioridad  : ").append(patient.getPriority()).append("\n");
	 
	            Set<String> meds = patient.getMedicationHistory();
	            if (meds.isEmpty()) {
	                sb.append("Medicamentos: (ninguno)\n");
	            } else {
	                sb.append("Medicamentos: ").append(String.join(", ", meds)).append("\n");
	            }
	            sb.append("_____________________________________\n");
	        }
	 
	        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Pacientes", JOptionPane.PLAIN_MESSAGE);
	    }    	
	    
	    
	//METODOS AUXILIARES PARA JOPTION
	    /**
	     * <b>Descripción: </b> Método encargado de mostrar un diálogo para seleccionar el tipo de identificación. <br>
	     * 
	     * @author Carlitos
	     *
	     * @param entity nombre de la entidad (para personalizar el mensaje)
	     * @return
	     * @return IdentificationTypeEnum seleccionado, o null si se canceló
	     * @throws Exception [Condición en la que ocurre]
	     */
	    private IdentificationTypeEnum selectIdentificationType(String entity) {
	        String[] options = {
	                "CC - Cédula de ciudadanía",
	                "TI - Tarjeta de identidad",
	                "CE - Cédula de extranjería",
	                "PA - Pasaporte"
	        };
	 
	        int choice = JOptionPane.showOptionDialog(
	                null,
	                "Seleccione el tipo de identificación del " + entity + ":",
	                "Tipo de Identificación",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                options,
	                options[0]
	        );
	 
	        return switch (choice) {
	            case 0 -> IdentificationTypeEnum.CC;
	            case 1 -> IdentificationTypeEnum.TI;
	            case 2 -> IdentificationTypeEnum.CE;
	            case 3 -> IdentificationTypeEnum.PA;
	            default -> null;
	        };
	    }
	 
	    /**
	     * <b>Descripción: </b> Método encargado de moestrar un diálogo para seleccionar la prioridad del paciente. <br>
	     * 
	     * @author Carlitos
	     *
	     * @return
	     * @return PriorityEnum seleccionada, o null si se canceló
	     */
	    private PriorityEnum selectPriority() {
	        String[] options = {
	                "BAJA   - Atención regular",
	                "MEDIA  - Atención moderada",
	                "ALTA   - Atención urgente",
	                "CRÍTICA - Atención inmediata"
	        };
	 
	        int choice = JOptionPane.showOptionDialog(
	                null,
	                "Seleccione la prioridad de atención del paciente:",
	                "Prioridad",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null,
	                options,
	                options[0]
	        );
	 
	        return switch (choice) {
	            case 0 -> PriorityEnum.LOW;
	            case 1 -> PriorityEnum.MEDIUM;
	            case 2 -> PriorityEnum.HIGH;
	            case 3 -> PriorityEnum.CRITICAL;
	            default -> null;
	        };
	    }
	    
	    
	    
	    
}	
			
			
			
			
			
			
			
			
		
