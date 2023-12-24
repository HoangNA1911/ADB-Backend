package dental_clinic.dental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class AppointmentDTO {
    @Id
    private int appointmentID;
    private int patientID;
    private int requestID;
    private String date;
    private String time;
    private int dentistID;
    private int roomID;
    private int orderNumber;
    private String status;
    private String patientName;
    private String dentistName;

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "appointmentID=" + appointmentID +
                ", patientID=" + patientID +
                ", requestID=" + requestID +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", dentistID=" + dentistID +
                ", roomID=" + roomID +
                ", orderNumber=" + orderNumber +
                ", status='" + status + '\'' +
                ", patientName='" + patientName + '\'' +
                ", dentistName='" + dentistName + '\'' +
                '}';
    }



    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDentistID() {
        return dentistID;
    }

    public void setDentistID(int dentistID) {
        this.dentistID = dentistID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }
}
