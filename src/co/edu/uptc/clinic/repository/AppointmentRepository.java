package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import co.edu.uptc.clinic.domain.MedicalAppointment;

public class AppointmentRepository {
	
	private Set<MedicalAppointment> appointments;

	public AppointmentRepository() {
		this.appointments = new HashSet<>();
	}
	
	public Set<MedicalAppointment> findAll() {
        return appointments;
    }

	
	public boolean save(MedicalAppointment appointment) {
		if(existById(appointment.getIdMedicalAppointment())) {
			return false;
		}
		return appointments.add(appointment);
	}
	
	
	
	public Optional<MedicalAppointment> findById(String id){
		return appointments.stream().filter(a -> a.getIdMedicalAppointment().equals(id))
				.findFirst();
	}
	
	public boolean existById(String id) {
		return appointments.stream().anyMatch(a -> a.getIdMedicalAppointment().equals(id));
	}
	
	public int count() {
		return appointments.size();
	}
	
	
}
