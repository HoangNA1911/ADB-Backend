package dental_clinic.dental.Controller;

import dental_clinic.dental.Repository.RequestRepository;
import dental_clinic.dental.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Controller
//http://localhost:8080/request
@RequestMapping("/appointments")
/*
- Requestmapping: để truy cập được đến controller này thì phải đi qua đường dẫn nào
- Các method trong này là các request tương ứng của user
*/
public class AppointmentController {
    @Autowired // sẽ tạo mới nếu không thấy object nào, còn neesu có rô thì tái sử dụng
    private RequestRepository requestRepository;
    //https://localhost:8080/request
    @RequestMapping(value ="", method = RequestMethod.GET)
    public String getAppointmentByDate(ModelMap modelMap) {
        // Kiểu dữ liệu gửi lên jsp là: ModelMap
        // return của teen file jsp
        Iterable<Request> requests = requestRepository.findAll();
        requests.forEach((p) -> {
            System.out.println(p.getRequest_id());
        });
        modelMap.addAttribute("requests", requests);




        return "AppointmentDate";
    }






}
