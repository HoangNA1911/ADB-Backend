package dental_clinic.dental.Controller;



import com.google.gson.Gson;
import dental_clinic.dental.Repository.EmployeeRepository;
import dental_clinic.dental.Util.ConvertJson2Object;
import dental_clinic.dental.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.sql.Date;

@RestController
//http://localhost:8080/request
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired // sẽ tạo mới nếu không thấy object nào, còn neesu có rô thì tái sử dụng
    private EmployeeRepository employeeRepository;
    private ConvertJson2Object convertEmp;


    //https://localhost:8080/request

    @RequestMapping(value ="/getEmployeeById/{EmployeeID}", method = RequestMethod.GET)
    public Optional<Employee> getAppointmentById(@PathVariable String EmployeeID) {
        // Kiểu dữ liệu gửi lên jsp là: ModelMap
        // return của teen file jsp
        Optional<Employee> e = employeeRepository.findById(EmployeeID);
        return e;

    }
    @RequestMapping(value ="/addEmployee", method = RequestMethod.POST)
    public String addEmp(@RequestBody Map<String, String> emp) {
        String empName = "";
        String gender = "";

        empName = emp.get("empName");
        gender = emp.get("gender");

        Date dob = Date.valueOf(emp.get("dob"));
        String address = emp.get("address");
        String role = emp.get("role");
        System.out.println(empName);
        String userId = employeeRepository.addEmp(empName, gender,dob,address, role);
        return userId;

    }
    @RequestMapping(value ="/getPlanDentist/{dentistId}", method = RequestMethod.GET)
    public  String getPlanDentist(@PathVariable int dentistId) {
        List<Map<String, Object>> jsonDataList = new ArrayList<>();
        List<Object[]> e = employeeRepository.viewDentistDetail(dentistId);
        for (Object[] row : e) {
            Map<String, Object> rowData = new LinkedHashMap<>();

            rowData.put("treatmentPlanId", row[0]); // Thêm tên trường cho entityType

            // Thêm các trường khác theo thứ tự hoặc tên trường tương ứng
            rowData.put("date", row[1]);
            rowData.put("status", row[2]);
            jsonDataList.add(rowData);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(jsonDataList);

        return jsonData;



    }
    @RequestMapping(value ="/deleteEmployeeById/{UserID}", method = RequestMethod.POST)
    public String deleteEmployeeById(@PathVariable int UserID, @RequestBody Map<String, String> empID) {

        String result = "";

        String eID = empID.get("empID");
        Optional<Employee> e = employeeRepository.findById(eID);

        if(e.isPresent()){

               employeeRepository.DeleteEmp(UserID);


                result = "delete success";


        } else{
            result = "not found";
        }



        return result;

    }

    @RequestMapping(value ="/EmpList", method = RequestMethod.GET)
    public String GETemp(){
        List<Object[]> ABC = employeeRepository.findJoinedData();
        List<Map<String, Object>> jsonDataList = new ArrayList<>();

        for (Object[] row : ABC) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("employeeID", row[0]); // Thêm tên trường cho entityType

            // Thêm các trường khác theo thứ tự hoặc tên trường tương ứng
            rowData.put("UserID", row[1]);
            rowData.put("empName", row[2]);
            rowData.put("gender", row[3]);
            rowData.put("dob", row[4]);
            rowData.put("address", row[5]);
            rowData.put("role", row[6]);

            jsonDataList.add(rowData);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(jsonDataList);

        return jsonData;
    }

    @RequestMapping(value ="/filterRoleGender/{gender}:{role}", method = RequestMethod.GET)
    public String filterEmpByGenderRole(@PathVariable String gender,@PathVariable String role) {
        List<Object[]> ABC = employeeRepository.filterEmpByGenderAndRole(gender,role);
        List<Map<String, Object>> jsonDataList = new ArrayList<>();

        for (Object[] row : ABC) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("employeeID", row[0]); // Thêm tên trường cho entityType

            // Thêm các trường khác theo thứ tự hoặc tên trường tương ứng
            rowData.put("UserID", row[1]);
            rowData.put("empName", row[2]);
            rowData.put("gender", row[3]);
            rowData.put("dob", row[4]);
            rowData.put("address", row[5]);
            rowData.put("role", row[6]);

            jsonDataList.add(rowData);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(jsonDataList);

        return jsonData;
    }
    @RequestMapping(value ="/changeEmp/{employeeID}", method = RequestMethod.POST)
    public Employee changeEmp( @RequestBody Map<String, Object> requestData) throws ParseException {
        Gson gson = new Gson();
        String jsonData = gson.toJson(requestData);
        Employee updateE = new Employee();

        updateE = convertEmp.json2Java(jsonData,Employee.class);

        updateE.toString();


        employeeRepository.save(updateE);
        return updateE;
    }


    @RequestMapping(value ="/searchEmp/{searchTerm}", method = RequestMethod.GET)
    public String searchEmp(@PathVariable String searchTerm) {


        List<Object[]> ABC = employeeRepository.searchEmp(searchTerm);
        List<Map<String, Object>> jsonDataList = new ArrayList<>();

        for (Object[] row : ABC) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("employeeID", row[0]); // Thêm tên trường cho entityType

            // Thêm các trường khác theo thứ tự hoặc tên trường tương ứng
            rowData.put("UserID", row[1]);
            rowData.put("empName", row[2]);
            rowData.put("gender", row[3]);
            rowData.put("dob", row[4]);
            rowData.put("address", row[5]);
            rowData.put("role", row[6]);

            jsonDataList.add(rowData);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(jsonDataList);

        return jsonData;
    }



}
