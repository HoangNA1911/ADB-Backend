package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.Employee_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeInfoRepository extends JpaRepository<Employee_info,String> {
}
