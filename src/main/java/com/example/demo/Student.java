package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "students")
@Getter
@Setter
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@JsonIgnore
    private Integer id;
    //@JsonProperty(value = "nme")
    private String name;

    private String address;

    @OneToOne
    private Card card;

    /*@ManyToMany
    @JsonManagedReference
    private Set<Professor> professors = new HashSet<>();*/

    public  void updateFrom(Student fromObject)
    {
        if(StringUtils.hasText(fromObject.getName()))
            this.name = fromObject.getName();
        if(StringUtils.hasText(fromObject.getAddress()))
            this.address = fromObject.getAddress();
    }
}
