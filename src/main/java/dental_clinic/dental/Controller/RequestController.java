package dental_clinic.dental.Controller;

import com.google.gson.Gson;
import dental_clinic.dental.Repository.RequestRepository;
import dental_clinic.dental.Util.ConvertJson2Object;
import dental_clinic.dental.model.Employee;
import dental_clinic.dental.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController//http://localhost:8080/request
@RequestMapping("/requests")
/*
- Requestmapping: để truy cập được đến controller này thì phải đi qua đường dẫn nào
- Các method trong này là các request tương ứng của user
*/
public class RequestController {
    @Autowired // sẽ tạo mới nếu không thấy object nào, còn neesu có rô thì tái sử dụng
    private RequestRepository requestRepository;
    private ConvertJson2Object convertRequest;
    //https://localhost:8080/request
    @RequestMapping(value ="/list", method = RequestMethod.GET)
   public Iterable<Request> getAllRequest() {

        return requestRepository.findAll();
   }
    @RequestMapping(value ="/{requestId}", method = RequestMethod.GET)
    public Optional<Request> getRequestId(@PathVariable int  requestId) {

        return requestRepository.findById(requestId);
    }

    @RequestMapping(value ="/searchByPhone/{searchTerm}", method = RequestMethod.GET)
    public Iterable<Request> searchByPhone(@PathVariable String searchTerm) {

        Iterable<Request> result = requestRepository.searchByPhone(searchTerm);
        return result;

    }
    @RequestMapping(value ="/filterByShift/{shift}", method = RequestMethod.GET)
    public Iterable<Request> filterByShift(@PathVariable String shift) {

        Iterable<Request> result = requestRepository.filterByShift(shift);
        return result;

    }
    @RequestMapping(value ="/filterByStatus/{status}", method = RequestMethod.GET)
    public Iterable<Request> filterByStatus(@PathVariable String status) {

        Iterable<Request> result = requestRepository.filterByStatus(status);
        return result;

    }
    @RequestMapping(value ="/deleteRequest/{requestId}", method = RequestMethod.POST)
    public void deleteRQ(@PathVariable int requestId) {

       requestRepository.deleteById(requestId);
    }
    @RequestMapping(value ="/createRequest", method = RequestMethod.POST)
    public Request createRequest(@RequestBody Map<String, Object> requestData) throws ParseException {
        Gson gson = new Gson();
        String jsonData = gson.toJson(requestData);
        Request newRequest = new Request();

        newRequest = convertRequest.json2Java(jsonData, Request.class);

        newRequest.toString();


        requestRepository.save(newRequest);
        return newRequest;
    }
    @RequestMapping(value ="/findPatient/{phone}", method = RequestMethod.GET)
    public int findPatient(@PathVariable int phone) throws ParseException {
        int result = requestRepository.findPatient(phone);
        return result;
    }




}
