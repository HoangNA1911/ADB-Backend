package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment,Long> {
}
