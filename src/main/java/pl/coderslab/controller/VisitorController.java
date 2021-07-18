package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "")
public class VisitorController {

    private final UserService userService;

    public VisitorController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/test")
    public String test(){
        return "visitorView/testV";
    }

    @GetMapping(value = "/panel")
    public String panelV(){
        return "visitorView/visitorPanel";
    }

    @GetMapping(value = "/register")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "visitorView/register";
    }
    @PostMapping(value = "/register")
    public String saveUser(@Valid User user, BindingResult result){
         User user1= userService.findUserByEmail(user.getEmail());
        if (result.hasErrors()) {
            return "visitorView/register";
        } else if (user1 != null) {
            result.rejectValue("email","error.user","taki email już mamy");
            return "visitorView/register";
        }
        userService.add(user);
        return "visitorView/visitorPanel";
    }

    @GetMapping("/login")
    public String login() {
        return "/visitorView/login";
    }
    @PostMapping("/login")
    public String loginPost(@RequestParam String email, String password, ServletRequest request) {
        List<User> users = userService.getUsers();
        if (email != null && !email.isBlank() && password != null && !password.isBlank() && users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getEmail().equals(email) && BCrypt.checkpw(password, users.get(i).getPassword())) {
                    User user = userService.findUserByEmail(email);

                    HttpServletRequest req = (HttpServletRequest) request;
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("user",user);

                    if(user.getAdmin() == 1){
                        return "redirect:/teacher/panel";
                    }
                    else return "redirect:/user/panel";
                }
            }
        }
        return "redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("user");
        return "redirect:/panel";
    }
}
