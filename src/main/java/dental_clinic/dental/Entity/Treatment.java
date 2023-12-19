package dental_clinic.dental.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Treatment {
    @Id
    private int Treatment_id;
    private int Parent_treatment_id;
    private String Treatment_plan;
    private int TM_cost;

}
