package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.DentistSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface DentistScheduleRepository extends JpaRepository<DentistSchedule,Long> {
    @Query(value="Call view_dentist_free(:date, :time)",nativeQuery = true)
    List<Object[]> findDentistAvailable(@Param("date") Date date, @Param("time") Date time);
}
