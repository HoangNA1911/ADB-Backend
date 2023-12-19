package dental_clinic.dental.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Treatment {
    @Id
    private String Treatment_id;
    private int Parent_treatment_id;
    private String Treatment_name;
    private int TM_cost;

}
