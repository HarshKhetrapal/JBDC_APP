package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String brand;

    @ManyToOne
    private Student student;

    public void updateFrom(Laptop fromObject) {
        if (StringUtils.hasText(fromObject.getBrand()))
            this.brand = fromObject.getBrand();
    }
}
