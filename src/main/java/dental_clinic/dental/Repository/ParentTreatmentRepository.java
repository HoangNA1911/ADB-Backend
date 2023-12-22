package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.ParentTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ParentTreatmentRepository extends JpaRepository<ParentTreatment,Long> {
    @Query(value = "call view_parent_treatment()",nativeQuery = true)
    List<Object[]> viewparenttreatment();
}
