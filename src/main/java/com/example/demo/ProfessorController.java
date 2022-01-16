package com.example.demo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/populateprofessor")
    public void populateProfessor()
    {
        Professor professor1 = new Professor();
        professor1.setName("ProfessorA");
        professor1.setSubject("SubjectA");

        professorService.createProfessor(professor1);

        Professor professor2 = new Professor();
        professor2.setName("ProfessorA");
        professor2.setSubject("SubjectA");

        professorService.createProfessor(professor2);

        Professor professor3 = new Professor();
        professor3.setName("ProfessorA");
        professor3.setSubject("SubjectA");

        professorService.createProfessor(professor3);

        /*Student student = new Student();
        student.setName("A");
        student.getProfessors().add(professor1);
        student.getProfessors().add(professor2);
        student.getProfessors().add(professor3);

        studentService.createStudent(student);*/
    }
}
