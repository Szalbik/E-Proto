package com.resource.proto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentService {

    public static List<Student> getAllStudents() {
        Student student1 = new Student(1, "Damian", "Szalbierz", new Date("dd MMM yyyy"));
        Student student2 = new Student(2, "Jan", "Nowak", new Date("dd MMM yyyy"));
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        return list;
    }

}
