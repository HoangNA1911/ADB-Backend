package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.Teeth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeethRepository extends JpaRepository<Teeth,Long> {
}
