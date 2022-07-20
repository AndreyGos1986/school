package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;


@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty( @RequestBody Faculty faculty) { // create
        return ResponseEntity.ok(facultyService.createFaculty(faculty));
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<Faculty>> getAllFac() {
        if (facultyService.getAllFac().isEmpty() == false) {
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
    public ResponseEntity<Collection<Faculty>> getFacByColor(@RequestParam(value = "color", required = false) String color) {
        if (color == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(facultyService.findByColor(color));
    }


    @PutMapping
    public ResponseEntity<Faculty> changeFaculty(@RequestBody Faculty changedFaculty) { //update
        if (changedFaculty != null) {
            return ResponseEntity.ok(facultyService.changeFaculty(changedFaculty));
        } else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeFaculty(@PathVariable("id") long id) { //delete
        if (id > 0) {
            facultyService.removeFaculty(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
