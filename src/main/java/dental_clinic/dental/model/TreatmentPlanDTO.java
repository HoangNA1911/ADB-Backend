package dental_clinic.dental.model;

public class TreatmentPlanDTO {

    private int patient_id;
    private int dentist_id;
    private String prescription;

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDentist_id() {
        return dentist_id;
    }

    public void setDentist_id(int dentist_id) {
        this.dentist_id = dentist_id;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(int assistant_id) {
        this.assistant_id = assistant_id;
    }

    public int getParent_treatment_id() {
        return parent_treatment_id;
    }

    public void setParent_treatment_id(int parent_treatment_id) {
        this.parent_treatment_id = parent_treatment_id;
    }

    public String getTeeth_array() {
        return teeth_array;
    }

    public void setTeeth_array(String teeth_array) {
        this.teeth_array = teeth_array;
    }

    public String getSurfaceteeth_array() {
        return surfaceteeth_array;
    }

    public void setSurfaceteeth_array(String surfaceteeth_array) {
        this.surfaceteeth_array = surfaceteeth_array;
    }

    public String getTreatment_id() {
        return treatment_id;
    }

    public void setTreatment_id(String treatment_id) {
        this.treatment_id = treatment_id;
    }

    private String note;
    private  int assistant_id;
    private int parent_treatment_id;
    private String teeth_array;
    private String surfaceteeth_array;
    private String treatment_id;
}
