package com.example.firstApp.Controller;

import com.example.firstApp.Entity.Student;
import com.example.firstApp.Service.StudentImplementation;
import com.example.firstApp.Service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController
{
    @Autowired
    private StudentImplementation studentImplementation;

    @GetMapping(path = "/getStudents")
    public List<Student> getStudents()
    {
        return studentImplementation.getStudents();
    }

    @GetMapping(path = "/getStudent/{id}")
    public Optional<Student> getStudent(@PathVariable Long id)
    {
        return studentImplementation.getStudent(id);
    }

    @PostMapping(path = "/addStudent")
    public Student saveStudent(@RequestBody Student student)
    {
        return studentImplementation.saveStudent(student);
    }

    @DeleteMapping(path = "/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable Long studentId)
    {
        Optional<Student> student=studentImplementation.getStudent(studentId);
        if(student.isPresent()) {
            studentImplementation.deleteStudent(studentId);
            return "Student "+student.get().getName()+" is deleted";

        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
