package ru.gb.studentlist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.studentlist.entity.Student;
import ru.gb.studentlist.service.StudentService;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService repository;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllStudents(Model model){

        model.addAttribute("students", repository.findAll());
        return "student-all";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String editStudent(Model model, @RequestParam Long id){
        Student student = repository.findById(id);
        model.addAttribute("student", student);
        return "create-student";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam(name = "id") Long id){
        repository.deleteById(id);
        return "redirect:/student/all";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String processForm(Student student){
        repository.save(student);
        return "redirect:/student/all";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String createStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create-student";
    }

}
