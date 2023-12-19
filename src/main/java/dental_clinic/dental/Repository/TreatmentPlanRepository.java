package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan,Long> {
}
