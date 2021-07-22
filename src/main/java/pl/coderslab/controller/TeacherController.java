package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Lesson;
import pl.coderslab.model.Section;
import pl.coderslab.model.User;
import pl.coderslab.model.dto.LessonDto;
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

// users/sections

    @GetMapping(value = "/editUserSections/{id}")
    public String editUserSectionsGet(@PathVariable Long id,Model model){
        User user = userService.get(id);
        List<Section> sections = sectionService.getSections();
        model.addAttribute("user", user);
        model.addAttribute("sections", sections);
        return "teacherView/editUserSections";
    }
    @PostMapping(value="/addUserSection/{userId}/{sectionId}")
    public String editUserSectionsAdd(@PathVariable Long userId,@PathVariable Long sectionId,Model model){
        User user = userService.get(userId);
        Section section = sectionService.get(sectionId);
//        user.setSections();
        // jak to dodać do tabeli users_sections

        return "/editUserSections/{userId}";
    }
    @PostMapping(value="/deleteUserSection/{userId}/{sectionId}")
    public String editUserSectionsDelete(@PathVariable Long userId,@PathVariable Long sectionId,Model model){
        User user = userService.get(userId);
        Section section = sectionService.get(sectionId);

        // jak to usunąć z tabeli users_sections

        return "/editUserSections/{userId}";
    }

// users

    @GetMapping(value = "/allUsers")
    public String showUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "teacherView/allUsers";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUserGet(@PathVariable Long id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "/teacherView/deleteUser";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUserPost(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/teacher/allUsers";
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
        model.addAttribute("lesson", new Lesson());
        model.addAttribute("sections",sections);
        model.addAttribute("lessonDto", new LessonDto());
        return "teacherView/addLesson";
    }
    @PostMapping(value = "/addLesson")
    public String saveLesson(@Valid LessonDto lessonDto, BindingResult result) {
        if (result.hasErrors()) {
            return "/teacherView/addLesson";
        }
        lessonService.add(lessonDto);
        return "redirect:/teacher/panel";
    }

    @GetMapping(value = "/editLesson/{id}")
    public String editLesson(@PathVariable long id, Model model) {
        Optional<Lesson> lesson = lessonService.get(id);
        List<Section> sections = sectionService.getSections();
        model.addAttribute("lessonDto", lesson);
        model.addAttribute("sections",sections);
        return "teacherView/addLesson";
    }

    @PostMapping(value = "/editLesson/{id}")
    public String updateLesson(@Valid LessonDto lessonDto, BindingResult result) {
        if (result.hasErrors()) {
            return "teacherView/addLesson";
        }
        lessonService.updateLesson(lessonDto);
        return "redirect:/teacher/allLessons";
    }

    @GetMapping("/showLesson/{id}")
    public String showLesson(@PathVariable long id, Model model) {
        Optional<Lesson> lesson = lessonService.get(id);
        model.addAttribute("lesson", lesson.get());
        return "teacherView/showLesson";
    }

    @GetMapping("/deleteLesson/{id}")
    public String deleteLessonGet(@PathVariable Long id, Model model) {
        Optional<Lesson> lesson = lessonService.get(id);
        model.addAttribute("lesson", lesson.get());
        return "/teacherView/deleteLesson";
    }

    @PostMapping("/deleteLesson/{id}")
    public String deleteLessonPost(@RequestParam Long id) {
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
        return "redirect:/teacher/allSections";
    }

    @GetMapping(value = "/editSection/{id}")
    public String editSection(@PathVariable long id, Model model) {
        Section section = sectionService.get(id);
        model.addAttribute("section",section);
        return "teacherView/addSection";
    }

    @PostMapping(value = "/editSection/{id}")
    public String updateSection(@Valid Section section, BindingResult result) {
        if (result.hasErrors()) {
            return "teacherView/addSection";
        }
        sectionService.update(section);
        return "redirect:/teacher/allSections";
    }

    @GetMapping("/deleteSection/{id}")
    public String deleteSectionGet(@PathVariable Long id, Model model) {
        Optional<Section> section = Optional.ofNullable(sectionService.get(id));
        model.addAttribute("section",section.get());
        return "/teacherView/deleteSection";
    }

    @PostMapping("/deleteSection/{id}")
    public String deleteSectionPost(@RequestParam Long id) {
        sectionService.delete(id);
        return "redirect:/teacher/allSections";
    }
}






