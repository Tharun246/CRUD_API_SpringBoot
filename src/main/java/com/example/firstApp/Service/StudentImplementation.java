package com.example.firstApp.Service;

import com.example.firstApp.Entity.Student;
import com.example.firstApp.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentImplementation implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudent(Long Id) {
        return studentRepo.findById(Id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public  String deleteStudent(Long StudentId)
    {
        studentRepo.deleteById(StudentId);

        return null;
    }


}
