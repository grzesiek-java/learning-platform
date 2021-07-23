package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.model.Lesson;
import pl.coderslab.model.Section;
import pl.coderslab.model.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    private Validator validator;

    @GetMapping("/validateUser")
    public String validateUser(Model model){
        User user = new User();
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        System.out.println(validate);
        for (ConstraintViolation<User> violation:validate) {
            System.out.println(violation.getPropertyPath() +" : "+ violation.getMessage());
        }
        model.addAttribute("validate",validate);
        if(validate.isEmpty()){
            return "/test";
        } else {
            return "/visitor/errors";
        }
    }
    @GetMapping("/validateLesson")
    public String validateLesson(Model model){
        Lesson lesson = new Lesson();
        Set<ConstraintViolation<Lesson>> validate = validator.validate(lesson);
        System.out.println(validate);
        for (ConstraintViolation<Lesson> violation:validate) {
            System.out.println(violation.getPropertyPath() +" : "+ violation.getMessage());
        }
        model.addAttribute("validate",validate);
        if(validate.isEmpty()){
            return "/test";
        } else {
            return "/visitor/errors";
        }
    }
    @GetMapping("/validateSection")
    public String validateSection(Model model){
        Section section = new Section();
        Set<ConstraintViolation<Section>> validate = validator.validate(section);
        System.out.println(validate);
        for (ConstraintViolation<Section> violation:validate) {
            System.out.println(violation.getPropertyPath() +" : "+ violation.getMessage());
        }
        model.addAttribute("validate",validate);
        if(validate.isEmpty()){
            return "/test";
        } else {
            return "/visitor/errors";
        }
    }
}
