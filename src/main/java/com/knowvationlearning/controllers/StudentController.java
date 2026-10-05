package com.knowvationlearning.controllers;

import com.knowvationlearning.entities.Student;
import com.knowvationlearning.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;
    //POST -> http://localhost:8080/students/save, it also accepts Student Object as requestbody
    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student addedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }

    //GET -> http://localhost:8080/students/
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudent(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    //GET -> http://localhost:8080/students/34
    @GetMapping("/{rollNumber}")
    public ResponseEntity<Student> getStudentByRollNumber(@PathVariable Integer rollNumber){
        Student student = studentService.getStudentByRollNumber(rollNumber);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //PUT -> http://localhost:8080/students/update -> also accept student object as request body
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
//        Student updatedStudent = studentService.updateStudentByRollNumber(student);
        return new ResponseEntity<>(studentService.updateStudentByRollNumber(student), HttpStatus.CREATED);
    }

    //DELETE -> http://localhost:8080/students/45
    @DeleteMapping("/{rollNumber}")
    public ResponseEntity<Student> deleteStudentByRollNumber(@PathVariable Integer rollNumber){
//        Student student = studentService.deleteStudentByRollNumber(rollNumber);
        return new ResponseEntity<>(studentService.deleteStudentByRollNumber(rollNumber), HttpStatus.OK);
    }
}
