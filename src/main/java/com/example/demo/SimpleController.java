package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SimpleController {

    DataBase db = new DataBase();

    // search -- https://www.google.com/search?q=sachin -- string

    @GetMapping("/search")
    public String searchAWord(@RequestParam String q)
    {
        String response = db.getInfoAboutWord(q);

        if(response == null)
            return "Couldn't find this word";

        return response;
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs()
    {
        return db.getAllDogs();
    }

    @GetMapping("/dogs/breed/{breed_name}")
    public List<Dog> getAllDogsByBreedName(@PathVariable String breed_name)
    {
        return db.getDogsByBreed(breed_name);
    }
    @GetMapping("/dogs/{id}")
    public Dog getDogById(@PathVariable int id)
    {
        return db.getDogById(id);
    }
}
