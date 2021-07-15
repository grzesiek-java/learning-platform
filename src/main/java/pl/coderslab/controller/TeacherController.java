package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Lesson;
import pl.coderslab.model.User;
import pl.coderslab.service.LessonService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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



    @GetMapping(value = "/editLesson/{id}")
    public String updateLesson(@PathVariable long id, Model model) {
        Optional<Lesson> lesson = lessonService.get(id);
        model.addAttribute("lesson", lesson.get());
        return "teacher/editLesson";
    }
    @PostMapping(value = "/editLesson/{id}")
    public String saveUpdatedLesson(@Valid Lesson lesson, BindingResult result) {
        if (result.hasErrors()) {
            return "teacher/editLesson";
        }
        lessonService.add(lesson);
        return "redirect:/teacher/allLessons";
    }

    @GetMapping("/showLesson/{id}")
    public String showLesson(@PathVariable long id, Model model) {
        Optional<Lesson> lesson = lessonService.get(id);
        model.addAttribute("lesson", lesson.get());
        return "teacher/showLesson";
    }


    @GetMapping("/deleteLesson/{id}")
    public String deleteGet(@PathVariable Long id, Model model) {
        Optional<Lesson> lesson = lessonService.get(id);
        model.addAttribute("lesson", lesson.get());
        return "/teacher/deleteLesson";
    }
    @PostMapping("/deleteLesson/{id}")
    public String deletePost(@RequestParam Long id){
        lessonService.delete(id);
        return "redirect:/teacher/allLessons";
    }
}
