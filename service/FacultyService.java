package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultys = new HashMap<>();
    private static long counter = 0;

    public Faculty createFaculty(Faculty faculty) { // create
        faculty.setId(++counter);
        faculty.setColor("");
        faculty.setName("");
        facultys.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty removeFaculty(Long id) { // delete
        return facultys.remove(id);
    }

    public Faculty getFaculty(Long id) { // read
        return facultys.get(id);
    } //read

    public Faculty changeFaculty(Faculty changedFaculty) { //update
        facultys.put(changedFaculty.getId(), changedFaculty);
        return changedFaculty;
    }
    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> fac= new ArrayList<>();
        for (Faculty faculty : facultys.values()) {
            if (faculty.getColor().equals(color)) {
                fac.add(faculty);
            }
        }
        return fac;
    }
    public Map <Long,Faculty> getAllFac (){
        return facultys;
    }

}
