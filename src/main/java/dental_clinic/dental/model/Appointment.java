package dental_clinic.dental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "APPOINTMENT")
public class Appointment {
    @Id
    @Column(name = "APPOINTMENT_ID")
    private int AppointmentId;
    @Column(name = "A_DENTIST_ID")
    private int dentist_id;
    @Column(name = "A_PATIENT_ID")
    private int patient_id;
    @Column(name = "A_ROOM_ID")
    private int room_id;
    @Column(name = "A_ORDER_NUMBER")
    private int order_number;
    @Column(name = "A_DATE")
    private Date date_appointment;
    @Column(name = "A_TIME")
    private Time time_appointment;
    @Column(name = "A_STATUS")
    private String status;



    public int getAppointment_id() {
        return AppointmentId;
    }

    public int getDentist_id() {
        return dentist_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public int getOrder_number() {
        return order_number;
    }

    public Date getDate_appointment() {
        return date_appointment;
    }

    public Time getTime_appointment() {
        return time_appointment;
    }

    public String getStatus() {
        return status;
    }

    public void setAppointment_id(int appointment_id) {
        this.AppointmentId = appointment_id;
    }

    public void setDentist_id(int dentist_id) {
        this.dentist_id = dentist_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public void setDate_appointment(Date date_appointment) {
        this.date_appointment = date_appointment;
    }

    public void setTime_appointment(Time time_appointment) {
        this.time_appointment = time_appointment;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
