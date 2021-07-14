package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    private final UserService userService;

    public TeacherController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/test")
    public String test(){
        return "teacher/testT";
    }
    @GetMapping(value = "/allUsers")
    public String showUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/all";
    }
}
