package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment,Long> {
    @Query(value ="call view_treatment(:parent_treatment_id);",nativeQuery = true )
    List<Object[]> findTreatmentByParent(@Param("parent_treatment_id") Integer parent_treatment_id);
}
