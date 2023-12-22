package dental_clinic.dental.Controller;



import com.google.gson.Gson;
import dental_clinic.dental.Repository.EmployeeRepository;
import dental_clinic.dental.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
//http://localhost:8080/request
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired // sẽ tạo mới nếu không thấy object nào, còn neesu có rô thì tái sử dụng
    private EmployeeRepository employeeRepository;



    //https://localhost:8080/request

    @RequestMapping(value ="/getEmployeeById/{EmployeeID}", method = RequestMethod.GET)
    public Optional<Employee> getAppointmentById(@PathVariable String EmployeeID) {
        // Kiểu dữ liệu gửi lên jsp là: ModelMap
        // return của teen file jsp
        Optional<Employee> e = employeeRepository.findById(EmployeeID);
        return e;

    }
    @RequestMapping(value ="", method = RequestMethod.GET)
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
    @RequestMapping(value ="/filterGender/{gender}", method = RequestMethod.GET)
    public List<Object[]> filterEmpByGender(@PathVariable String gender) {
        return employeeRepository.filterEmpByGender(gender);
    }
}
