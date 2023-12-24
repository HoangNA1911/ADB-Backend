package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.PatientInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientInfoRepository extends JpaRepository<PatientInfo,Long> {
    @Query("SELECT p FROM PatientInfo p WHERE p.patient_ID = :id or p.pp_Name LIKE %:name%")
    Page<PatientInfo> findByIdOrNameContaining(@Param("id") int id, @Param("name") String name, Pageable pageable);
    @Query("SELECT p FROM PatientInfo p WHERE p.pp_Name LIKE %:name%")
    Page<PatientInfo> findByNameContaining(@Param("name") String search, Pageable pageable);

    @Query("SELECT p FROM  PatientInfo p Where p.pp_Email =:email")
    PatientInfo findByPp_Email(@Param("email")String Pp_Email);
}
