package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.DentistSchedule;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DentistScheduleRepository extends JpaRepository<DentistSchedule,Long> {
    @Query(value="call view_dentist_free(:date_chosen, :time_chosen);",nativeQuery = true)
    List<Integer> findDentistAvailable(@Param("date_chosen") Date date_chosen, @Param("time_chosen") Time time_chosen);

}
