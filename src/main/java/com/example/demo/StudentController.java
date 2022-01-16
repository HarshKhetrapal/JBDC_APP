package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Integer id)
    {
        return studentService.getStudent(id);
    }

    @GetMapping("/student")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @PostMapping("/student")
    public Integer createStudent(@RequestBody Student student)
    {
        return studentService.createStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public Integer deleteStudent(@PathVariable Integer id)
    {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/student/name/{name}")
    public  Student getStudentByName(@PathVariable String name)
    {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/student/name/{name}/address/{address}")
    public Student getStudentByNameAndAddress(@PathVariable String name, @PathVariable String address)
    {
        return studentService.getStudentByNameAndAddress(name, address);
    }

    @GetMapping("/students/{name}")
    public List<Student> getCustomStudentByName(@PathVariable String name)
    {
        return studentService.customGetStudentsByName(name);
    }


    @Autowired
    CardService cardService;

    @GetMapping("/populatecards")
    public String populateCards()
    {
        Card card1 = new Card();
        card1.setDescription("Description1");

        cardService.createCard(card1);

        Card card2 = new Card();
        card2.setDescription("Description1");

        cardService.createCard(card2);

        return "Success";
    }

    @PostMapping("/student/{cardId}")
    public Integer createStudent(@RequestBody Student student, @PathVariable Integer cardId)
    {
        return studentService.createStudent(student, cardId);
    }
}
