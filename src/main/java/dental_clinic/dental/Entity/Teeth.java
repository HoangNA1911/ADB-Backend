package dental_clinic.dental.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teeth {
    @Id
    private int Teeth_id;
    private String Teeth_name;
}
