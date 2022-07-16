package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) { // create
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id) { // read
        if (studentService.getAll().values() != null) {
            return ResponseEntity.ok(studentService.getStudentFromStudentMapAtFaculty(id));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<ArrayList<Student>> getStudentsByAge(@RequestParam int age) {
        if (age > 0 & studentService.findByAge(age) != null) {
            return ResponseEntity.ok(studentService.findByAge(age));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Map<Long, Student>> getAllStudents() {
        if (studentService.getAll().values() != null) {
            return ResponseEntity.ok(studentService.getAll());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Student> changeStudent(@RequestBody Student changedStudent) { //update
        return ResponseEntity.ok(studentService.changeStudentAtStudentMapAtFaculty(changedStudent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> removeStudent(@PathVariable long id) { //delete
        if (studentService.getAll().values() != null) {
            return ResponseEntity.ok(studentService.removeStudentFromStudentMapAtFaculty(id));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

