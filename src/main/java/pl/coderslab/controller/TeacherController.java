package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Lesson;
import pl.coderslab.model.User;
import pl.coderslab.service.LessonService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    private final UserService userService;
    private final LessonService lessonService;

    public TeacherController(UserService userService,LessonService lessonService){
        this.userService = userService;
        this.lessonService = lessonService;
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

    @GetMapping(value = "/allLessons")
    public String showLessons(Model model){
        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("lessons", lessons);
        return "teacher/allLessons";
    }
    @GetMapping(value = "/addLesson")
    public String addLesson(Model model){
        model.addAttribute("lesson",new Lesson());
        return "teacher/addLesson";
    }
    @PostMapping(value = "/addLesson")
    public String saveLesson(@Valid Lesson lesson, BindingResult result){
        if (result.hasErrors()){
            return "/teacher/addLesson";
        }
        lessonService.add(lesson);
        return "redirect:/test";
    }
}
