package com.knowvationlearning.services;

import com.knowvationlearning.entities.Student;
import com.knowvationlearning.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);
    Student getStudentByRollNumber(Integer rollNumber) throws StudentNotFoundException;
    List<Student> getAllStudent() throws StudentNotFoundException;
    Student deleteStudentByRollNumber(Integer rollNumber) throws StudentNotFoundException;
    Student updateStudentByRollNumber(Student student) throws StudentNotFoundException;
}
