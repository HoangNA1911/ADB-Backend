//package dental_clinic.dental.Service;
//
//import dental_clinic.dental.Entity.Users;
//import dental_clinic.dental.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//    private final TokenService tokenService;
//
//
//
//    @Autowired
//    UserService(UserRepository userRepository, TokenService tokenService) {
//        this.userRepository = userRepository;
//        this.tokenService = tokenService;
//        //this.authenticationManager = authenticationManager;
//    }
//
//    public Users getUser(int userId) {
//        return userRepository.findById((long) userId).orElse(null);
//    }
//    public String saveUser(Users user) {
//        Users savedUSER = userRepository.save(user);
//        return tokenService.createToken(savedUSER.getUserID());
//    }
//
//    public ResponseEntity<String> login(String user_name, String password){
//        try {
//            Optional<Users> user = userRepository.findByUserNameAndPassword(user_name, password);
//            if(user.isEmpty()){
//                throw new BadCredentialsException("login not successful");
//            }
//            String token = tokenService.createToken(user.get().getUserID());
//            return ResponseEntity.ok(token);
//        }catch (BadCredentialsException e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//}
