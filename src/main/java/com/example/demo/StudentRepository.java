package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Struct;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByName(String name);
    Student findByNameAndAddress(String name, String address);

    @Query(value = "select * from students", nativeQuery = true)
    List<Student> customFindAllStudent();

    @Query(value = "select * from students where name = :name", nativeQuery = true)
    List<Student> customFindStudentByName(@Param("name") String name);
}
