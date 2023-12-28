package dental_clinic.dental.Controller;

import dental_clinic.dental.Repository.AppointmentRepository;
import dental_clinic.dental.Repository.ReTreatmentRepository;

import dental_clinic.dental.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
//http://localhost:8080/request
@RequestMapping("/retreatments")
public class RetreatmentController {
    @Autowired // sẽ tạo mới nếu không thấy object nào, còn neesu có rô thì tái sử dụng
    private ReTreatmentRepository reTreatmentRepository;

    //https://localhost:8080/request
    @RequestMapping(value ="/view_retreatment", method = RequestMethod.GET)
    public Optional<Object[]> getAppointmentById() {
        // Kiểu dữ liệu gửi lên jsp là: ModelMap
        // return của teen file jsp
       Optional<Object[]> result = reTreatmentRepository.viewRe();
        return result;

    }
    @RequestMapping(value ="/{retreatmentId}", method = RequestMethod.GET)
    public Optional<Object> getAppointmentById(@PathVariable int retreatmentId) {
        // Kiểu dữ liệu gửi lên jsp là: ModelMap
        // return của teen file jsp
        Optional<Object> result = reTreatmentRepository.viewReDetail(retreatmentId);
        return result;

    }
    @RequestMapping(value ="/update/{retreatmentId}", method = RequestMethod.GET)
    public String updateStatus(@PathVariable int retreatmentId) {
        // Kiểu dữ liệu gửi lên jsp là: ModelMap
        // return của teen file jsp
        String result = reTreatmentRepository.updateRe(retreatmentId);
        return result;

    }

}
