package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.SurfaceTeeth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurfaceRepository extends JpaRepository<SurfaceTeeth,Long> {
}
