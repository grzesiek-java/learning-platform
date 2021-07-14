package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.service.UserService;

@Controller
@RequestMapping(value = "")
public class VisitorController {

    private final UserService userService;

    public VisitorController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/test")
    public String test(){
        return "testV";
    }
}
