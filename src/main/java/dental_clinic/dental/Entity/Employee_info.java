package dental_clinic.dental.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)

public class Employee_info {
    @Id
    private String Employee_id ;
    private int User_Ii;
    private String Emp_name;
    private String Gender;
    private Date Date_of_birth;
    private String Address;

}
