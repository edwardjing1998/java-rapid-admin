package admin.controller;

import admin.dto.UserDTO;
import admin.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/robotLabel/users")
    public List<UserDTO> getUsersByFdrid() {
        return userService.getUsersByFdrid("PROD");
    }
}
