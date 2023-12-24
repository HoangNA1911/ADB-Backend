package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.TeethTreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeethTreatmentPlanRepository extends JpaRepository<TeethTreatmentPlan,Long> {
}
