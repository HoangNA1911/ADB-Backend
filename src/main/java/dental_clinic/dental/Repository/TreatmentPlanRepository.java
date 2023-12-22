package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan,Long> {
    @Query(value = "call add_treatment_plan(:patient_id,:dentist_id,:prescription,:assistant_id,:note,:parent_treatment_id," +
            ":teeth_array,:surfaceteeth_array,:treatment_id);",nativeQuery = true)
    List<Object[]> addTreatmentPlan(@Param("patient_id") int patient_id,
                                    @Param("dentist_id") int dentist_id,
                                    @Param("prescription") String prescription,
                                    @Param("assistant_id") int assistant_id,
                                    @Param("note") String note,
                                    @Param("parent_treatment_id") int parent_treatment_id,
                                    @Param("teeth_array") String teeth_array,
                                    @Param("surfaceteeth_array") String surfaceteeth_array,
                                    @Param("treatment_id") String treatment_id);


}
