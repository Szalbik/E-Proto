package com.resource.proto;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    private static Map<Long, Student> students = new HashMap<>();
    private static Map<Long, Course> courses = new HashMap<>();
    private  static Map<Long, Grade> grades = new HashMap<>();

    public static Map<Long, Student> getStudents() {
        return students;
    }

    public static Map<Long, Course> getCourses() {
        return courses;
    }

    public static Map<Long, Grade> getGrades() {
        return grades;
    }
}
