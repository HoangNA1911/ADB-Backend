package dental_clinic.dental.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ParentTreatment {
    @Id
    private int Parent_treatment_id;
    private String Parent_treatment_name;

}
