package dental_clinic.dental.Repository;

import dental_clinic.dental.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.parameters.P;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query(value ="Call view_emp_info();", nativeQuery = true)
    List<Object[]> findJoinedData( );

    @Query(value = "call filter_emp_gender_role(:gender, :role);", nativeQuery = true)
    List<Object[]> filterEmpByGenderAndRole(
            @Param("gender") String gender,
            @Param("role") String role
    );
    @Transactional
    @Modifying
    @Query(value = "call deleteUserEmp(:UserID);", nativeQuery = true)
    void DeleteEmp(
            @Param("UserID") int UserID
    );

    @Query(value = "call searchEmployee(:searchTerm);", nativeQuery = true)
    List<Object[]> searchEmp(
            @Param("searchTerm") String searchTerm
    );
    @Query(value = "call  view_treatment_plan_list(:dentistId);", nativeQuery = true)
    List<Object[]> viewDentistDetail(
            @Param("dentistId") int dentist_id
    );

    @Query(value = "call add_employee(:empName, :gender, :dob, :address, :role);", nativeQuery = true)
    String addEmp(
            @Param("empName") String empName,
            @Param("gender") String gender,
            @Param("dob") Date dob,
            @Param("address") String address,
            @Param("role") String role
    );


    @Query(value ="call filter_emp_gender(:gender);", nativeQuery = true)
    List<Object[]> filterEmpByGender(@Param("gender") String gender);

    @Query("select e FROM Employee  e WHERE e.userid in :userID")
    Page<Employee> findByUerid(@Param("userID") List<Integer>userID, Pageable pageable);

}
