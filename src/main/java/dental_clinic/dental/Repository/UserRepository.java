package dental_clinic.dental.Repository;

import dental_clinic.dental.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserNameAndPassword(String userName, String password);
    User findByUserName(String userName);
}
