//package dental_clinic.dental.Repository;
//
//import dental_clinic.dental.Entity.Users;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository<Users, Long> {
//    Optional<Users> findByUserNameAndPassword(String userName, String password);
//
//    Users findByUserName(String userName);
//
//}
