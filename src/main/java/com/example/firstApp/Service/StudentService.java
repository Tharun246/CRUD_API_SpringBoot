package com.example.firstApp.Service;

import com.example.firstApp.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService
{
    List<Student> getStudents();

    Optional<Student> getStudent(Long Id);
    Student saveStudent(Student student);

    String deleteStudent(Long studId);

}
