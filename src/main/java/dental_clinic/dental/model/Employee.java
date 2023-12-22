package dental_clinic.dental.model;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;




import lombok.Builder;
import lombok.NoArgsConstructor;
//import org.apache.tomcat.util.json.ParseException;

import java.text.SimpleDateFormat;

//import java.sql.Date;
import java.util.Locale;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE_INFO")

public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")

    private  String EmployeeID;
    @Column(name = "USER_ID")
    private int UserID;
    @Column(name = "EMP_NAME")
    private String EmpName;
    @Column(name = "GENDER")
    private String Gender;
    @Column(name = "DATE_OF_BIRTH")
    private Date DOB;
    @Column(name = "ADDRESS")
    private String Address;




    public String getEmployeeID() {
        return EmployeeID;
    }

    public int getUserID() {
        return UserID;
    }

    public String getEmpName() {
        return EmpName;
    }

    public String getGender() {
        return Gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getAddress() {
        return Address;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setAddress(String address) {
        Address = address;
    }

}
