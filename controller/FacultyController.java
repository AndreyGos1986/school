package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(Faculty faculty) { // create
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<Long, Faculty>> getAllFac() {
        if (facultyService.getAllFac().values() != null) {
            return ResponseEntity.ok(facultyService.getAllFac());
        } else return ResponseEntity.badRequest().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultytInfoById(@PathVariable long id) { // read
        if (id > 0) {
            return ResponseEntity.ok(facultyService.getFaculty(id));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getFacByColor(@RequestParam String color) {
        if (color != null) {
            ResponseEntity.ok(facultyService.findByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @PutMapping
    public ResponseEntity<Faculty> changeFaculty(@RequestBody Faculty changedFaculty) { //update
        if (changedFaculty != null) {
            return ResponseEntity.ok(facultyService.changeFaculty(changedFaculty));
        } else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity <Faculty> removeFaculty(@PathVariable long id) { //delete
       if (id>0) {
           return ResponseEntity.ok(facultyService.removeFaculty(id));
       } else return ResponseEntity.notFound().build();
    }


}
