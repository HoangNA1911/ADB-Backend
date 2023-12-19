package dental_clinic.dental.Repository;

import dental_clinic.dental.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query(value ="Call view_emp_info();", nativeQuery = true)
    List<Object[]> findJoinedData();

    @Query(value ="call filter_emp_gender(:gender);", nativeQuery = true)
    List<Object[]> filterEmpByGender(@Param("gender") String gender);
}
