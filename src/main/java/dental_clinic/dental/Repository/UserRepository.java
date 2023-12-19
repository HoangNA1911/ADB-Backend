package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUserNameAndPassword(String userName, String password);
    Users findByUserName(String userName);
}
