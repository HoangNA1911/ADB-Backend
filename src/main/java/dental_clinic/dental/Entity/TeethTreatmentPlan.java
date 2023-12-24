package dental_clinic.dental.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TeethTreatmentPlan {
    @Id
    private int Teeth_treatment_plan_id;
    private int TT_treatment_plan_id;
    private int TT_teeth_id;
    private int TT_surface_id;

}
