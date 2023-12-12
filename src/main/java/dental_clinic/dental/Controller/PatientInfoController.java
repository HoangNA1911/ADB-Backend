package dental_clinic.dental.Controller;

import dental_clinic.dental.Entity.PatientInfo;
import dental_clinic.dental.Repository.PatientInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patientInfo")
public class PatientInfoController {
    private PatientInfoRepository patientInfoRepository;

    public PatientInfoController(PatientInfoRepository patientInfoRepository) {
        this.patientInfoRepository = patientInfoRepository;
    }

    @GetMapping("/list")
    @ResponseBody
    public Page<PatientInfo> searchPatient(@RequestParam(name = "page", required = false) Integer pageNum,
                                           @RequestParam(name = "search", required = false) String search) {
        Integer page = pageNum;
        if (pageNum == null || pageNum < 0) {
            page = 0;
        }
        Pageable pageable = PageRequest.of(page, 10);

        if(search != null && !search.isEmpty()){
            if(tryParseInt(search)) {
                return patientInfoRepository.findByIdOrNameContaining(Integer.parseInt(search), search, pageable);
            }else{
                return patientInfoRepository.findByNameContaining(search, pageable);
            }
        }
        return patientInfoRepository.findAll(pageable);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addpatient(@RequestBody PatientInfo patientInfo) {
        patientInfoRepository.save(patientInfo);
        return ResponseEntity.ok("add patient info success");
    }
//    @GetMapping("search")
//    public

    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true; // Parsing successful
        } catch (NumberFormatException e) {
            return false; // Parsing failed
        }
    }

}
