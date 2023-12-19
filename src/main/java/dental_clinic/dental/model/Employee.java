package dental_clinic.dental.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Time;
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

    private int userid;
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
        return userid;
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
        userID = userID;
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
