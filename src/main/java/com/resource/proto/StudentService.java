package com.resource.proto;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StudentService {
    private Map<Long, Student> students = DatabaseClass.getStudents();

    public StudentService() {
        students.put(1l, new Student(1l, "Damian", "Szalbierz", new Date()));
        students.put(2l, new Student(2l, "Katarzyna", "Bonecka", new Date()));
    }

    public List<Student> getStudents() {
        return new ArrayList<Student>(students.values());
    }

    public Student getStudent(long id) {
        return students.get(id);
    }

    public Student addStudent(Student student) {
        student.setIndex(students.size() + 1);
        students.put(student.getIndex(), student);
        return student;
    }

    public Student updateStudent(Student student) {
        if (student.getIndex() <= 0) {
            return null;
        }
        students.put(student.getIndex(), student);
        return student;
    }

    public Student removeStudent(long id) {
        return students.remove(id);
    }
}
