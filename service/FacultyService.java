package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;


import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepositoriy;
    public FacultyService(FacultyRepository facultyRepositoriy) {
        this.facultyRepositoriy = facultyRepositoriy;
    }
    public Faculty createFaculty(Faculty faculty) { // create
        return facultyRepositoriy.save(faculty);
    }

    public Faculty getFaculty(Long id) { // read
        return facultyRepositoriy.findById(id).get();

    }

    public Faculty changeFaculty(Faculty changedFaculty) { //update
        return facultyRepositoriy.save(changedFaculty);
    }

    public void removeFaculty(Long id) { // delete
       facultyRepositoriy.deleteById(id);

    }

    public Collection<Faculty> findByColor(String color) {
        return facultyRepositoriy.findAll()
                .stream()
                .filter(faculty -> faculty.getColor()
                        .equals(color))
                .collect(Collectors
                        .toList());
    }

    public Collection<Faculty> getAllFac() {
        return facultyRepositoriy.findAll();
    }

}
