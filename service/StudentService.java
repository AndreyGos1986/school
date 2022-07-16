package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {
    private final Map<Long, Student> listOfStudents = new HashMap<>();
    private static long counter = 0;

    public Student createStudent(Student student) { // create
        student.setId(++counter);
        listOfStudents.put(student.getId(), student);
        return student;
    }

    public Student removeStudentFromStudentMapAtFaculty(Long id) { // delete
        return listOfStudents.remove(id);
    }

    public Student getStudentFromStudentMapAtFaculty(Long id) { // read
        return listOfStudents.get(id);
    } // read

    public Student changeStudentAtStudentMapAtFaculty(Student changedStudent) { //update
        listOfStudents.put(changedStudent.getId(), changedStudent);
        return changedStudent;
    }
    public Map getAll () {
        return listOfStudents;
    }


    public ArrayList<Student> findByAge(int age) {
        ArrayList<Student> studList = new ArrayList<>();
        for (Student student : listOfStudents.values()) {
            if (student.getAge() == age) {
                studList.add(student);
            }
        }
        return studList;
    }

}
