package dental_clinic.dental.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;



import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Time;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REQUEST")
public class Request {
    @Id
    @Column(name = "REQUEST_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  int request_id;
    @Column(name = "RQ_PATIENT_ID")
    private  int patient_id;
    @Column(name = "RQ_DATE_TIME")
    private  Date dateRequest ;

    @Column(name = "RQ_TIME")
    private Time timeRequest;
    @Column(name = "RQ_NOTE")
    private String noteRequest;
    @Column(name = "RQ_PHONE")
    private  String phoneNumber;
    @Column(name = "RQ_STATUS")
    private  String statusRequest = "pending";






    @Override
    public String toString() {
        return "ViewRequest{" +
                "request_id=" + request_id +
                ", patient_id=" + patient_id +
                ", dateRequest=" + dateRequest +
                ", noteRequest='" + noteRequest + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", statusRequest='" + statusRequest + '\'' +
                '}';
    }

    public int getRequest_id() {
        return request_id;
    }

    public String getNoteRequest() {
        return noteRequest;
    }

    public String getStatusRequest() {
        return statusRequest;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Time getTimeRequest() {
        return timeRequest;
    }



    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public void setNoteRequest(String noteRequest) {
        this.noteRequest = noteRequest;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStatusRequest(String statusRequest) {
        this.statusRequest = statusRequest;
    }
}
