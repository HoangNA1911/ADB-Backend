package dental_clinic.dental.Repository;

import dental_clinic.dental.model.Appointment;
import dental_clinic.dental.model.Retreatment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReTreatmentRepository  extends CrudRepository<Retreatment, Integer> {
    @Query(value = "call  view_retreatment_detail(:reTreatment_id);", nativeQuery = true)
    Optional<Object> viewReDetail(
            @Param("reTreatment_id") int reTreatment_id
    );
    @Query(value = "call  view_retreatment();", nativeQuery = true)
    Optional<Object[]> viewRe(
    );
    @Query(value = "call update_status_retreatment(:reTreatment_id);", nativeQuery = true)
   String updateRe(
            @Param("reTreatment_id") int reTreatment_id
    );
}
