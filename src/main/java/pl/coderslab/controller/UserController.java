package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.model.Section;
import pl.coderslab.model.User;
import pl.coderslab.service.SectionService;
import pl.coderslab.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final SectionService sectionService;

    public UserController(UserService userService,SectionService sectionService){
        this.userService = userService;
        this.sectionService = sectionService;
    }

    @GetMapping("/test")
    public String test(){
        return "userView/testU";
    }

    @GetMapping(value = "/panel")
    public String panelU(Model model){

        List<Section> sections = sectionService.getSections();
        model.addAttribute("sections", sections);
        return "userView/userPanel";
    }

//    @GetMapping(value = "/editUserSections/{id}")
//    public String editUserSectionsGet(@PathVariable Long id, Model model){
//        Optional<User> user = userService.get(id);
//        List<Section> sections = sectionService.getSections();
//        model.addAttribute("user", user.get());
//        model.addAttribute("sections", sections);
//        return "teacherView/editUserSections";
//    }
}
