package dental_clinic.dental.Controller;

import dental_clinic.dental.Entity.Employee_info;
import dental_clinic.dental.Entity.PatientInfo;
import dental_clinic.dental.Repository.DentistScheduleRepository;
import dental_clinic.dental.Repository.ParentTreatmentRepository;
import dental_clinic.dental.Repository.PatientInfoRepository;
import dental_clinic.dental.Repository.TreatmentRepository;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/treatment")
public class TreatmentPlanController {
    private PatientInfoRepository  patientInfoRepository;
    private DentistScheduleRepository dentistScheduleRepository;
    private ParentTreatmentRepository parentTreatmentRepository;
    public TreatmentPlanController(PatientInfoRepository patientInfoRepository,
                                   DentistScheduleRepository dentistScheduleRepository,
                                    ParentTreatmentRepository parentTreatmentRepository){
        this.patientInfoRepository=patientInfoRepository;
        this.dentistScheduleRepository=dentistScheduleRepository;
        this.parentTreatmentRepository=parentTreatmentRepository;
    }
    @GetMapping("/choosepatient")
    public ResponseEntity<PatientInfo> infoPatient(@RequestParam(name="email", required = true)String email){
        PatientInfo patientInfo = patientInfoRepository.findByPp_Email(email);
        return ResponseEntity.ok(patientInfo);
    }
    @GetMapping("/listDentistAvail")
    public List<Object[]> filterDentistAvailable(@RequestParam(name="date",required = true)Date date,
                                                 @RequestParam(name="time",required = true)Time time){



        List<Object[]>result =dentistScheduleRepository.findDentistAvailable(date,time);
        return result;
    }
    @GetMapping("/listParentTreatment")
    public List<Object[]> listParentTreatment(){
        return parentTreatmentRepository.viewparenttreatment();
    }
}
