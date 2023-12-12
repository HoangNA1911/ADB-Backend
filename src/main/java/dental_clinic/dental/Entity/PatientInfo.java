package dental_clinic.dental.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity

public class PatientInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int patient_ID;
    @Column(columnDefinition = "NVARCHAR(255) COLLATE utf8mb4_unicode_ci")
    private String pp_Name;
    private String pp_Gender;
    private String pp_Oral_Health;
    private String pp_Allergy;
    private int pp_TotalCost;
    private int pp_TotalPaid;
    private String PP_PHONENUMBER;
    private String pp_Email;
    private String pp_Address;
    private Date pp_Date_Of_Birth;

    public int getPatient_ID() {
        return patient_ID;
    }

    public void setPatient_ID(int patient_ID) {
        this.patient_ID = patient_ID;
    }

    public String getPp_Name() {
        return pp_Name;
    }

    public void setPp_Name(String pp_Name) {
        this.pp_Name = pp_Name;
    }

    public String getPp_Gender() {
        return pp_Gender;
    }

    public void setPp_Gender(String pp_Gender) {
        this.pp_Gender = pp_Gender;
    }

    public String getPp_Oral_Health() {
        return pp_Oral_Health;
    }

    public void setPp_Oral_Health(String pp_Oral_Health) {
        this.pp_Oral_Health = pp_Oral_Health;
    }

    public String getPp_Allergy() {
        return pp_Allergy;
    }

    public void setPp_Allergy(String pp_Allergy) {
        this.pp_Allergy = pp_Allergy;
    }

    public int getPp_TotalCost() {
        return pp_TotalCost;
    }

    public void setPp_TotalCost(int pp_TotalCost) {
        this.pp_TotalCost = pp_TotalCost;
    }

    public int getPp_TotalPaid() {
        return pp_TotalPaid;
    }

    public void setPp_TotalPaid(int pp_TotalPaid) {
        this.pp_TotalPaid = pp_TotalPaid;
    }

    public String getPp_Phone_Number() {
        return PP_PHONENUMBER;
    }

    public void setPp_PhoneNumber(String pp_PhoneNumber) {
        this.PP_PHONENUMBER = pp_PhoneNumber;
    }

    public String getPp_Email() {
        return pp_Email;
    }

    public void setPp_Email(String pp_Email) {
        this.pp_Email = pp_Email;
    }

    public String getPp_Address() {
        return pp_Address;
    }

    public void setPp_Address(String pp_Address) {
        this.pp_Address = pp_Address;
    }

    public Date getPp_Date_Of_Birth() {
        return pp_Date_Of_Birth;
    }

    public void setPp_Date_Of_Birth(Date pp_Date_Of_Birth) {
        this.pp_Date_Of_Birth = pp_Date_Of_Birth;
    }
}
