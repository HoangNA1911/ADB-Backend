//package dental_clinic.dental.Service;
//
//import dental_clinic.dental.Entity.User;
//import dental_clinic.dental.Repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CustomUserService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public CustomUserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(userName);
//        UserDetails userDetails =
//                org.springframework.security.core.userdetails.User.builder()
//                        .username(user.getUserName())
//                        .password(user.getPassword())
//                        .build();
//        return userDetails;
//    }
//}