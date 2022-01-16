package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    List<User> lst = new ArrayList<>();
    @GetMapping("/hello/{data}")
    public List<String> getHelloWorld(@PathVariable String  data, @RequestHeader Map<String, String> req)
    {
        List<String> lst = new ArrayList<>();
        lst.add("Hello");
        lst.add("World");
        lst.add("!!!");
        lst.add("Another String");
        lst.add(data);
        System.out.println(req);
        return lst;
    }

    @GetMapping("user/{name}")
    public User getUser(@PathVariable String name)
    {
        User usr = new User();
        usr.setId(1);
        usr.setName(name);
        return usr;
    }

    @PostMapping("user/create")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        for (User usr : lst)
            if(usr.getId() == user.getId())
                return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
        lst.add(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("user/update")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        for (User usr : lst)
            if(usr.getId() == user.getId())
            {
                usr.setName(user.getName());
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id)
    {
        for (int i = 0; i < lst.size(); i++)
            if(lst.get(i).getId() == id)
            {
                lst.remove(i);
                return new ResponseEntity<>("Deleted Sucessfully", HttpStatus.OK);
            }
        return new ResponseEntity<>("Not able to Delete", HttpStatus.OK);
    }
}
