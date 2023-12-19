package dental_clinic.dental.Controller;

import dental_clinic.dental.Entity.Employee_info;
import dental_clinic.dental.Entity.PatientInfo;
import dental_clinic.dental.Repository.DentistScheduleRepository;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/treatment")
public class TreatmentPlanController {
    private PatientInfoRepository  patientInfoRepository;
    private DentistScheduleRepository dentistScheduleRepository;
    public TreatmentPlanController(PatientInfoRepository patientInfoRepository,DentistScheduleRepository dentistScheduleRepository){
        this.patientInfoRepository=patientInfoRepository;
        this.dentistScheduleRepository=dentistScheduleRepository;
    }
    @GetMapping("/choosepatient")
    public ResponseEntity<PatientInfo> infoPatient(@RequestParam(name="email", required = true)String email){
        PatientInfo patientInfo = patientInfoRepository.findByPp_Email(email);
        return ResponseEntity.ok(patientInfo);
    }
    @GetMapping("/listDentistAvail")
    public List<Object[]> filterDentistAvailable(@RequestParam(name="date",required = true)String date,
                                                 @RequestParam(name="time",required = true)String time){

        String patternDate="yyyy-MM-dd";

        String patternTime="HH:mm:ss";
        SimpleDateFormat dateFormat=new SimpleDateFormat(patternDate);
        SimpleDateFormat timeFormat= new SimpleDateFormat(patternTime);
        Date dateConvert;
        Date timeConvert;
        try{
            dateConvert= dateFormat.parse(date);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try{
            timeConvert= timeFormat.parse(time);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        List<Object[]>result =dentistScheduleRepository.findDentistAvailable(dateConvert,timeConvert);
        return result;
    }
}
