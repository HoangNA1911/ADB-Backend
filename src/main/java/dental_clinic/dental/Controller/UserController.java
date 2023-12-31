package dental_clinic.dental.Controller;

import dental_clinic.dental.Entity.Users;
import dental_clinic.dental.Repository.UserRepository;
import dental_clinic.dental.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        String user_name = user.getUserName();
        String password = user.getPassword();
        ResponseEntity<String> result = userService.login(user_name, password);
        return result;
    }
    @GetMapping("/register")
    public ResponseEntity<String> register(){

        return  ResponseEntity.ok("hello");
    }

    @GetMapping("/get")
    public ResponseEntity<String> getUser(@RequestAttribute("userId")String userId   ) {
        return ResponseEntity.ok(userId);
    }
}
