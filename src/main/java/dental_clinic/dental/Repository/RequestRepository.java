package dental_clinic.dental.Repository;

import com.google.gson.Gson;
import dental_clinic.dental.model.Employee;
import dental_clinic.dental.model.Request;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface RequestRepository extends CrudRepository<Request, Integer> {
    @Query(value = "call  view_request();", nativeQuery = true)
    List<Object[]> viewRequest();
    @Query(value = "call filter_request(:phone);", nativeQuery = true)
    Iterable<Request> searchByPhone(
            @Param("phone") String phone
    );
    @Query(value = "call filter_request_by_shift(:shift);", nativeQuery = true)
    Iterable<Request> filterByShift(
            @Param("shift") String shift
    );
    @Query(value = "call findRequest(:phone);", nativeQuery = true)
    int findPatient(
            @Param("phone") int phone
    );




}
