package dental_clinic.dental.Controller;

import dental_clinic.dental.Repository.AppointmentRepository;
import dental_clinic.dental.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
//http://localhost:8080/request
@RequestMapping("/appointments")
/*
- Requestmapping: để truy cập được đến controller này thì phải đi qua đường dẫn nào
- Các method trong này là các request tương ứng của user
*/
public class AppointmentController {
    @Autowired // sẽ tạo mới nếu không thấy object nào, còn neesu có rô thì tái sử dụng
    private AppointmentRepository appointmentRepository;
    //https://localhost:8080/request
    @RequestMapping(value ="/getAppointmentById/{AppointmentId}", method = RequestMethod.GET)
    public Optional<Appointment> getAppointmentById(@PathVariable int AppointmentId) {
        // Kiểu dữ liệu gửi lên jsp là: ModelMap
        // return của teen file jsp
        Optional<Appointment> appointments = appointmentRepository.findById(AppointmentId);
        return appointments;

    }
}
