package dental_clinic.dental.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Time;
import java.util.Date;

@Entity
public class DentistSchedule {
    @Id
    private int Schedule_id;

    private int Dentist_id;
    private Date Schedule_date;
    private Date Schedule_time;

    private boolean isOff;
    private boolean isAppointment;



}
