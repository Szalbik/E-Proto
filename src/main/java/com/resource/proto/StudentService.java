package com.resource.proto;

import java.util.*;

public class StudentService {
    private Map<Long, Student> students = DatabaseClass.getStudents();

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
