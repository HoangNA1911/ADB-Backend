package dental_clinic.dental.Repository;

import dental_clinic.dental.model.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}
