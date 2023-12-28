package dental_clinic.dental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RETREATMENT")
public class Retreatment {
    @Id
    @Column(name = "RETREATMENT_ID")
    private int retreatmentID;

    @Column(name = "RT_TREATMENT_PLAN_ID")
    private int treatmentPlanID;

    @Column(name = "RT_NOTE")
    private String note;

    @Column(name = "RT_DATE")
    private Date date;

    @Column(name = "STATUS")
    private String status;

}
