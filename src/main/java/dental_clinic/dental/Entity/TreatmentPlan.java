package dental_clinic.dental.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class TreatmentPlan {
    @Id
    private int Treatment_plan_id;
    private int TP_patient_id;
    private int TP_dentist_id;
    private int TP_Prescription;
    private int TP_assistant_id;
    private String note;
    private String status;
    private int TP_treatment_id;
    private int Parent_treatment_id;
    private Date TP_date;
}
