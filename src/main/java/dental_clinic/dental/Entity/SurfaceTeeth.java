package dental_clinic.dental.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class SurfaceTeeth {
    @Id
    private int Surface_id;
    private String Surface_name;
}
