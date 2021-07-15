package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "")
public class VisitorController {

    private final UserService userService;

    public VisitorController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/test")
    public String test(){
        return "visitor/testV";
    }

    @GetMapping(value = "/panel")
    public String panelV(){
        return "visitor/visitorPanel";
    }

    @GetMapping(value = "/register")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "visitor/register";
    }
    @PostMapping(value = "/register")
    public String saveUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "visitor/register";
        }
        userService.add(user);
        return "redirect:/panel";
    }

}
