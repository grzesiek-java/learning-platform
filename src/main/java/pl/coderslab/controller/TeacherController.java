package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Lesson;
import pl.coderslab.model.Section;
import pl.coderslab.model.User;
import pl.coderslab.service.LessonService;
import pl.coderslab.service.SectionService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    private final UserService userService;
    private final LessonService lessonService;
    private final SectionService sectionService;


    public TeacherController(UserService userService, LessonService lessonService, SectionService sectionService) {
        this.userService = userService;
        this.lessonService = lessonService;
        this.sectionService = sectionService;
    }

// test

    @GetMapping("/test")
    public String test() {
        return "teacherView/testT";
    }

// panel

    @GetMapping(value = "/panel")
    public String panelT() {
        return "teacherView/teacherPanel";
    }

// users

    @GetMapping(value = "/allUsers")
    public String showUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "userView/all";
    }

// lessons

    @GetMapping(value = "/allLessons")
    public String showLessons(Model model) {
        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("lessons", lessons);
        return "teacherView/allLessons";
    }

    @GetMapping(value = "/addLesson")
    public String addLesson(Model model) {
        List<Section> sections = sectionService.getSections();
        model.addAttribute("sections",sections);
        model.addAttribute("lesson", new Lesson());
        return "teacherView/addLesson";
    }
    @PostMapping(value = "/addLesson")
    public String saveLesson(Lesson lesson, BindingResult result) {
        if (result.hasErrors()) {
            return "/teacherView/addLesson";
        }
        lessonService.add(lesson);
        return "redirect:/teacher/panel";
    }

    @GetMapping(value = "/editLesson/{id}")
    public String updateLesson(@PathVariable long id, Model model) {
        Optional<Lesson> lesson = lessonService.get(id);
        model.addAttribute("lesson", lesson.get());
        return "teacherView/editLesson";
    }

    @PostMapping(value = "/editLesson/{id}")
    public String saveUpdatedLesson(@Valid Lesson lesson, BindingResult result) {
        if (result.hasErrors()) {
            return "teacherView/editLesson";
        }
        lessonService.add(lesson);
        return "redirect:/teacher/allLessons";
    }

    @GetMapping("/showLesson/{id}")
    public String showLesson(@PathVariable long id, Model model) {
        Optional<Lesson> lesson = lessonService.get(id);
        model.addAttribute("lesson", lesson.get());
        return "teacherView/showLesson";
    }

    @GetMapping("/deleteLesson/{id}")
    public String deleteGet(@PathVariable Long id, Model model) {
        Optional<Lesson> lesson = lessonService.get(id);
        model.addAttribute("lesson", lesson.get());
        return "/teacherView/deleteLesson";
    }

    @PostMapping("/deleteLesson/{id}")
    public String deletePost(@RequestParam Long id) {
        lessonService.delete(id);
        return "redirect:/teacher/allLessons";
    }

// sections

    @GetMapping(value = "/allSections")
    public String showSections(Model model) {
        List<Section> sections = sectionService.getSections();
        model.addAttribute("sections",sections);
        return "teacherView/allSections";
    }

    @GetMapping(value = "/addSection")
    public String addSection(Model model) {
        model.addAttribute("section", new Section());
        return "/teacherView/addSection";
    }

    @PostMapping(value = "/addSection")
    public String saveSection(@Valid Section section, BindingResult result) {
        if (result.hasErrors()) {
            return "/teacherView/addSection";
        }
        sectionService.add(section);
        return "redirect:/teacher/panel";
    }
    @GetMapping(value = "/addLessonSection")
    public String addLessonSection(Model model) {
        List<Section> sections = sectionService.getSections();
        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("sections", sections);
        model.addAttribute("lessons", lessons);
        return "/teacherView/addLessonToSection";
    }

}

//    @GetMapping(value = "/addLesson")
//    public String addLesson(Model model){
//        model.addAttribute("lesson",new Lesson());
//        return "teacherView/addLesson";
//    }
//    @PostMapping(value = "/addLesson")
//    public String saveLesson(@Valid Lesson lesson, BindingResult result){
//        if (result.hasErrors()){
//            return "/teacherView/addLesson";
//        }
//        lessonService.add(lesson);
//        return "redirect:/test";




