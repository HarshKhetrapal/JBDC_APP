package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private StudentService studentService;

    public Integer createLaptop(Laptop laptop){
        laptop.setId(null);
        Laptop createdLaptop = laptopRepository.save(laptop);
        return createdLaptop.getId();
    }

    public Laptop getLaptop(Integer id)
    {
        Optional<Laptop> optional = laptopRepository.findById(id);

        if(optional.isPresent())
            return optional.get();

        return null;
    }

    public Laptop updateLaptop(Laptop laptop, Integer studentId)
    {
        Laptop exsistingLaptop = this.getLaptop(laptop.getId());
        if(exsistingLaptop == null)
            return null;
        exsistingLaptop.updateFrom(laptop);

        Student exsistingStudent = studentService.getStudent(studentId);
        if(exsistingStudent != null)
            exsistingLaptop.setStudent(exsistingStudent);

        exsistingLaptop = laptopRepository.save(exsistingLaptop);
        return exsistingLaptop;
    }
}
