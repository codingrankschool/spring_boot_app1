package com.knowvationlearning.services;

import com.knowvationlearning.entities.Student;
import com.knowvationlearning.exceptions.StudentNotFoundException;
import com.knowvationlearning.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImple implements  StudentService{

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentByRollNumber(Integer rollNumber) throws StudentNotFoundException {
        return studentRepository.findById(rollNumber).orElseThrow(()->new StudentNotFoundException("Invalid Roll Number"+rollNumber));
    }

    @Override
    public List<Student> getAllStudent() throws  StudentNotFoundException {
        List<Student> studentList = studentRepository.findAll();
        if(studentList.isEmpty()){
            throw new StudentNotFoundException("No Student found");
        }
        return studentList;
    }

    @Override
    public Student deleteStudentByRollNumber(Integer rollNumber) throws StudentNotFoundException {
        Student student = getStudentByRollNumber(rollNumber);
        studentRepository.deleteById(rollNumber);
        return student;
    }

    @Override
    public Student updateStudentByRollNumber(Student student) throws StudentNotFoundException {
        getStudentByRollNumber(student.getRollNumber());
        return studentRepository.save(student);
    }
}
