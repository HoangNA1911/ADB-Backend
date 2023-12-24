package dental_clinic.dental.Repository;

import dental_clinic.dental.model.Appointment;
import dental_clinic.dental.model.AppointmentDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    @Query(value = "call  view_appointment();", nativeQuery = true)
    List<Object[]> viewAppointment();

    @Query(value = "call  filter_appointment_patient(:patientName);", nativeQuery = true)
    List<Object[]> appointmentPatient(
            @Param("patientName") String patientName
    );
    @Query(value = "call   view_dentist_free(:date, :time);", nativeQuery = true)
    List<Object> dentist_free(
            @Param("date") Date date,
            @Param("time") Time time
    );
    @Query(value = "call   create_appointment(:request_id,:date_chosen,:time_chosen,:patient_id,:dentist_id);", nativeQuery = true)
    String createAppointment(
            @Param("request_id") int request_id ,
            @Param("date_chosen") Date date_chosen,
            @Param("time_chosen") Time time_chosen,
            @Param("patient_id") int patient_id,
            @Param("dentist_id") int dentist_id
    );
    @Query(value = "call  view_appointment_detail(:appointment_id);", nativeQuery = true)
    Optional<Object> viewAppointmentDetail(
            @Param("appointment_id") int appointment_id
    );




}
