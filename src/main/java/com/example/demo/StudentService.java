package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CardService cardService;

    public Integer createStudent(Student student)
    {
        student.setId(null);
        Student createdStudent = studentRepository.save(student);
        return createdStudent.getId();
    }

    public Integer createStudent(Student student, Integer cardId)
    {
        student.setId(null);
        Card savedCard = cardService.getCard(cardId);
        if(savedCard == null)
            return -1;
        student.setCard(savedCard);
        Student createdStudent = studentRepository.save(student);
        return createdStudent.getId();
    }

    public Student getStudent(Integer id)
    {
        Optional<Student> optional = studentRepository.findById(id);

        if(optional.isPresent())
            return optional.get();

        return null;
    }

    public Student updateStudent(Student student)
    {
        Student existingStudent = getStudent(student.getId());

        if(existingStudent != null)
        {
            existingStudent.updateFrom(student);
            existingStudent = studentRepository.save(existingStudent);
            return existingStudent;
        }
        return null;
    }

    public Integer deleteStudent(Integer id)
    {
        Student student = getStudent(id);

        if(student != null)
        {
            studentRepository.delete(student);
            return student.getId();
        }
        return null;
    }

    public List<Student> getAllStudents()
    {
        return studentRepository.customFindAllStudent();
    }

    public  Student getStudentByName(String name)
    {
        return studentRepository.findByName(name);
    }

    public Student getStudentByNameAndAddress(String name, String address)
    {
        return  studentRepository.findByNameAndAddress(name, address);
    }

    public List<Student> customGetStudentsByName(String name)
    {
        return studentRepository.customFindStudentByName(name);
    }
}
