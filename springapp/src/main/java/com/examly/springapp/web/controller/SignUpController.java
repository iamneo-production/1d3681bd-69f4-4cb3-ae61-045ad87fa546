import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SignUpController {

    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;

    @PostMapping("/admin/signup")
    @ResponseBody
    public String registerAdminAccount(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        adminService.save(userRegistrationDto);
        return "Admin Saved";
    }
    @PostMapping("/user/signup")
    @ResponseBody
    public String registerUserAccount(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        userService.save(userRegistrationDto);
        return "User Saved";
    }
}
