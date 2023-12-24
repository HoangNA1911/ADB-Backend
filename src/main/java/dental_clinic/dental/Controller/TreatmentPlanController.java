package dental_clinic.dental.Controller;

import com.google.gson.Gson;
import dental_clinic.dental.Entity.PatientInfo;
import dental_clinic.dental.Repository.*;
import dental_clinic.dental.model.TreatmentPlanDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping("/treatment")
public class TreatmentPlanController {
    private PatientInfoRepository  patientInfoRepository;
    private DentistScheduleRepository dentistScheduleRepository;
    private ParentTreatmentRepository parentTreatmentRepository;
    private EmployeeRepository employeeRepository;
    private TreatmentRepository treatmentRepository;
    private TreatmentPlanRepository treatmentPlanRepository;
    public TreatmentPlanController(PatientInfoRepository patientInfoRepository,
                                   DentistScheduleRepository dentistScheduleRepository,
                                    ParentTreatmentRepository parentTreatmentRepository,
                                   EmployeeRepository employeeRepository,
                                   TreatmentRepository treatmentRepository,
                                   TreatmentPlanRepository treatmentPlanRepository){
        this.patientInfoRepository=patientInfoRepository;
        this.dentistScheduleRepository=dentistScheduleRepository;
        this.parentTreatmentRepository=parentTreatmentRepository;
        this.employeeRepository=employeeRepository;
        this.treatmentRepository=treatmentRepository;
        this.treatmentPlanRepository=treatmentPlanRepository;
    }


    private List<Object[]> calculateCurrentPageContent(List<Object[]> fullList, int page) {
        int start = (page - 1) * 15;
        int end = Math.min(start + 15, fullList.size());

        return fullList.subList(start, end);
    }
    @GetMapping("/choosepatient")
    public ResponseEntity<PatientInfo> infoPatient(@RequestParam(name="email", required = true)String email){
        PatientInfo patientInfo = patientInfoRepository.findByPp_Email(email);
        return ResponseEntity.ok(patientInfo);
    }
    @GetMapping("/listDentistAvail")
    public ResponseEntity<String> filterDentistAvailable(@RequestParam(name="date",required = true)Date date,
                                                                 @RequestParam(name="time",required = true)Time time,
                                                                 @RequestParam(name = "page",required = false) int page){
        Integer pageNum=page;
        if(pageNum ==null || pageNum <1){
            pageNum=1;
        }
        List<Object[]> listUsersID =dentistScheduleRepository.findDentistAvailable(date,time);
        listUsersID= calculateCurrentPageContent(listUsersID,pageNum);
        List<Map<String,Object>> jsonDataList=new ArrayList<>();
        for (Object[] row : listUsersID) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("user_ID", row[0]);
            jsonDataList.add(rowData);
        }
        Gson gson = new Gson();
        String jsonData = gson.toJson(jsonDataList);
        return ResponseEntity.ok(jsonData);
    }
    @GetMapping("/listParentTreatment")
    public ResponseEntity<String> view_parent_treatment(){
        List<Object[]> result= parentTreatmentRepository.viewparenttreatment();
        List<Map<String,Object>> jsonDataList=new ArrayList<>();
        for (Object[] row : result) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("parent_treatment_id", row[0]);
            rowData.put("parent_treatment_name", row[1]);
            jsonDataList.add(rowData);
        }
        Gson gson = new Gson();
        String jsonData = gson.toJson(jsonDataList);
        return ResponseEntity.ok(jsonData);
    }
    @GetMapping("/listTreatment")
    public ResponseEntity<String> list_treatment_by_parent(@RequestParam(name="parent_id",required = true)Integer parent_id){
        List<Object[]> result= treatmentRepository.findTreatmentByParent(parent_id);
        List<Map<String,Object>> jsonDataList=new ArrayList<>();
        for (Object[] row : result) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("treatment_id", row[0]);
            rowData.put("parent_treatment_id", row[1]);
            rowData.put("treatment_name",row[2]);
            rowData.put("cost",row[3]);

            jsonDataList.add(rowData);
        }
        Gson gson = new Gson();
        String jsonData = gson.toJson(jsonDataList);
        return ResponseEntity.ok(jsonData);
    }
    @PostMapping("/addTreatmentPlan")
    public ResponseEntity<String> add_treatmentplan(@RequestBody TreatmentPlanDTO treatmentPlanDTO){
        int patient_id= treatmentPlanDTO.getPatient_id();
         int dentist_id= treatmentPlanDTO.getDentist_id();
         String prescription= treatmentPlanDTO.getPrescription();
         String note= treatmentPlanDTO.getNote();
         int assistant_id= treatmentPlanDTO.getAssistant_id();
         int parent_treatment_id= treatmentPlanDTO.getParent_treatment_id();
         String teeth_array= treatmentPlanDTO.getTeeth_array();
         String surfaceteeth_array= treatmentPlanDTO.getSurfaceteeth_array();
         String treatment_id= treatmentPlanDTO.getTreatment_id();
        List<Object[]> reuslt= treatmentPlanRepository.addTreatmentPlan(patient_id,dentist_id,prescription,assistant_id,note,parent_treatment_id,teeth_array,surfaceteeth_array,treatment_id);
         return ResponseEntity.ok("okeokoeokokeok");
    }
}
