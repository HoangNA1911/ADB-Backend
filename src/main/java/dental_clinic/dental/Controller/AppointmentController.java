package dental_clinic.dental.Controller;

import com.google.gson.Gson;
import dental_clinic.dental.Repository.AppointmentRepository;
import dental_clinic.dental.model.Appointment;
import dental_clinic.dental.model.AppointmentDTO;
import dental_clinic.dental.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.*;


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
    @RequestMapping(value ="/list", method = RequestMethod.GET)
    public String getAllRequest() {

        List<Object[]> ABC =  appointmentRepository.viewAppointment();
        List<Map<String, Object>> jsonDataList = new ArrayList<>();

        for (Object[] row : ABC) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("appointmentID", row[0]); // Thêm tên trường cho entityType

            // Thêm các trường khác theo thứ tự hoặc tên trường tương ứng
            rowData.put("patientID", row[1]);
            rowData.put("requestID", row[2]);
            rowData.put("date", row[3]);
            rowData.put("time", row[4]);
            rowData.put("dentistID", row[5]);
            rowData.put("roomID", row[6]);
            rowData.put("orderNumber", row[7]);
            rowData.put("status", row[8]);
            rowData.put("patientName", row[9]);
            rowData.put("dentistName", row[10]);
            rowData.put("EmpID", row[11]);

            jsonDataList.add(rowData);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(jsonDataList);

        return jsonData;
    }
    @RequestMapping(value ="/byPatient/{patientName}", method = RequestMethod.GET)
    public String getAppointmentByPatient(@PathVariable String patientName) {



        List<Object[]> ABC =  appointmentRepository.appointmentPatient(patientName);
        List<Map<String, Object>> jsonDataList = new ArrayList<>();

        for (Object[] row : ABC) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("appointmentID", row[0]); // Thêm tên trường cho entityType

            // Thêm các trường khác theo thứ tự hoặc tên trường tương ứng
            rowData.put("patientID", row[1]);
            rowData.put("requestID", row[2]);
            rowData.put("date", row[3]);
            rowData.put("time", row[4]);
            rowData.put("dentistID", row[5]);
            rowData.put("roomID", row[6]);
            rowData.put("orderNumber", row[7]);
            rowData.put("status", row[8]);
            rowData.put("patientName", row[9]);
            rowData.put("dentistName", row[10]);
            rowData.put("EmpID", row[11]);

            jsonDataList.add(rowData);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(jsonDataList);

        return jsonData;
    }
    @RequestMapping(value ="/viewDentistFree/{date}/{time}", method = RequestMethod.GET)
    public List<Object>  viewDentistFreeAppointment(@PathVariable Date date, @PathVariable Time time) {
        // Kiểu dữ liệu gửi lên jsp là: ModelMap
        // return của teen file jsp
        List<Object> dentistFree = appointmentRepository.dentist_free(date,time);
        return dentistFree;

    }
    @RequestMapping(value ="/addAppointment", method = RequestMethod.POST)
    public String addEmp(@RequestBody Map<String, String> appointment) {


        String rq_id = appointment.get("request_id");
        int request_id = Integer.parseInt(rq_id);
        Date date_chosen = Date.valueOf(appointment.get("date_chosen"));

        Time time_chosen = Time.valueOf(appointment.get("time_chosen"));
        String patientId =  appointment.get("patient_id");;
        int patient_id =Integer.parseInt(patientId);
        String dentistId =  appointment.get("dentist_id");
        int dentist_id =Integer.parseInt(dentistId);

        String appointmentId = appointmentRepository.createAppointment(request_id,date_chosen,time_chosen,patient_id,dentist_id);
        return appointmentId;

    }
    @RequestMapping(value ="/byID/{appointmentID}", method = RequestMethod.GET)
    public Optional<Object>  getAppointmentByID(@PathVariable int appointmentID) {



        Optional<Object> ABC =  appointmentRepository.viewAppointmentDetail(appointmentID);

        return ABC;
    }

}
