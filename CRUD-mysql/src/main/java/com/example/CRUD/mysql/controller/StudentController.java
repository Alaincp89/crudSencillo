package com.example.CRUD.mysql.controller;

import com.example.CRUD.mysql.entity.Student;
import com.example.CRUD.mysql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getAll(){
        return studentService.getStudents();
    }
    @GetMapping("/{studentId}")
    public Optional<Student> getbyId(@PathVariable ("studentId") Long studentId) {
        return studentService.getStudent(studentId);
    }
    @PostMapping
    public void saveUpdate(@RequestBody Student student){
        studentService.saveOrUddate(student);

    }
    @DeleteMapping("/{studentId}")
    public void saveUpdate(@PathVariable("studentId") Long studentId){
        studentService.delete(studentId);
    }
    
}
