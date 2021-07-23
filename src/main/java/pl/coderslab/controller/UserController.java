package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.model.Lesson;
import pl.coderslab.model.Section;
import pl.coderslab.model.User;
import pl.coderslab.service.LessonService;
import pl.coderslab.service.SectionService;
import pl.coderslab.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final SectionService sectionService;
    private final LessonService lessonService;

    public UserController(UserService userService,SectionService sectionService,LessonService lessonService){
        this.userService = userService;
        this.sectionService = sectionService;
        this.lessonService = lessonService;
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

    @GetMapping(value = "/showUserLessons/{id}")
    public String showLessons(Model model,@PathVariable Long id) {
        Section section = sectionService.get(id);
        model.addAttribute("section",section);
        return "userView/sectionLessons";
    }
    @GetMapping(value = "/showLesson/{id}")
    public String showLesson(Model model,@PathVariable Long id) {
        Optional<Lesson> lesson = lessonService.get(id);
        model.addAttribute("lesson",lesson.get());
        return "userView/showLesson";
    }

}
