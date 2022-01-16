package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/populatelaptop")
    public String populateLaptop()
    {
        Laptop laptop1 = new Laptop();
        laptop1.setBrand("HP");
        laptopService.createLaptop(laptop1);

        Laptop laptop2 = new Laptop();
        laptop2.setBrand("Apple");
        laptopService.createLaptop(laptop2);

        Laptop laptop3 = new Laptop();
        laptop3.setBrand("Lenovo");
        laptopService.createLaptop(laptop3);

        return "Success";
    }

    @PutMapping("/laptop/student/{studentId}")
    public Laptop updateLaptop(@RequestBody Laptop laptop, @PathVariable Integer studentId)
    {
        return laptopService.updateLaptop(laptop, studentId);
    }
}
