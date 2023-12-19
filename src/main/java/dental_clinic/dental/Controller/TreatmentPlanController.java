package dental_clinic.dental.Controller;

import dental_clinic.dental.Entity.PatientInfo;
import dental_clinic.dental.Entity.Treatment;
import dental_clinic.dental.Repository.*;
import dental_clinic.dental.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/treatment")
public class TreatmentPlanController {
//    @Autowired
//    private EntityManager em;
//    public List getAllParentTreatment(){
//        return em.createNamedStoredProcedureQuery("view_parent_treatment").getResultList();
//    }
    private PatientInfoRepository  patientInfoRepository;
    private DentistScheduleRepository dentistScheduleRepository;
    private ParentTreatmentRepository parentTreatmentRepository;
    private EmployeeRepository employeeRepository;
    private TreatmentRepository treatmentRepository;
    public TreatmentPlanController(PatientInfoRepository patientInfoRepository,
                                   DentistScheduleRepository dentistScheduleRepository,
                                    ParentTreatmentRepository parentTreatmentRepository,
                                   EmployeeRepository employeeRepository,
                                   TreatmentRepository treatmentRepository){
        this.patientInfoRepository=patientInfoRepository;
        this.dentistScheduleRepository=dentistScheduleRepository;
        this.parentTreatmentRepository=parentTreatmentRepository;
        this.employeeRepository=employeeRepository;
        this.treatmentRepository=treatmentRepository;
    }
    @GetMapping("/choosepatient")
    public ResponseEntity<PatientInfo> infoPatient(@RequestParam(name="email", required = true)String email){
        PatientInfo patientInfo = patientInfoRepository.findByPp_Email(email);
        return ResponseEntity.ok(patientInfo);
    }
    @GetMapping("/listDentistAvail")
    public ResponseEntity<Page<Employee>> filterDentistAvailable(@RequestParam(name="date",required = true)Date date,
                                                                 @RequestParam(name="time",required = true)Time time,
                                                                 @RequestParam(name = "page",required = false) Integer page){
        Integer pageNum=page;
        if(pageNum ==null || pageNum <0){
            pageNum=0;
        }
        Pageable pageable=  PageRequest.of(pageNum,15);
        List<Integer>listUsersID =dentistScheduleRepository.findDentistAvailable(date,time);
        Page<Employee> result= employeeRepository.findByUseridIn(listUsersID,pageable);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/listParentTreatment")
    public ResponseEntity<List> view_parent_treatment(){

//         List result= getAllParentTreatment() ;
        List result= parentTreatmentRepository.viewparenttreatment();
         return ResponseEntity.ok(result);
    }
    @GetMapping("/listTreatment")
    public ResponseEntity<List> list_treatment_by_parent(@RequestParam(name="parent_id",required = true)Integer parent_id){
        List result= treatmentRepository.findTreatmentByParent(parent_id);
        return ResponseEntity.ok(result);
    }
}
