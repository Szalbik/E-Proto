package com.resource.proto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class mockModel {

    private static final List<Student> students = new ArrayList<>();

    static {
        List<Grade> grades = new ArrayList<>();
        Grade tempGrade = new Grade();
        /////////// student 1
        tempGrade.setId(10);
        tempGrade.setValue(4);
        tempGrade.setDate(new Date("2018/4/9"));
        tempGrade.setCourse(new Course(54, "Matematyka", "Jan Kowalski"));
        grades.add(tempGrade);
        tempGrade = new Grade();
        //
        tempGrade.setId(14);
        tempGrade.setValue(3);
        tempGrade.setDate(new Date("2018/4/7"));
        tempGrade.setCourse(new Course(54, "Fizyka", "Jan Nowak"));
        grades.add(tempGrade);
        tempGrade = new Grade();
        //
        tempGrade.setId(12);
        tempGrade.setValue(5);
        tempGrade.setDate(new Date("2018/4/8"));
        tempGrade.setCourse(new Course(59, "Chemia", "Piotr Kwiatkowski"));
        grades.add(tempGrade);
        tempGrade = new Grade();
        //
        Student student = new Student(105, "Alexy", "Petrow", new Date("1995/2/15"), grades);
        students.add(student);
        grades =  new ArrayList<>();
        /////////// student 2
        tempGrade.setId(1);
        tempGrade.setValue(4.5f);
        tempGrade.setDate(new Date("2018/4/9"));
        tempGrade.setCourse(new Course(54, "Matematyka", "Jan Kowalski"));
        grades.add(tempGrade);
        tempGrade = new Grade();
        //
        tempGrade.setId(8);
        tempGrade.setValue(3.5f);
        tempGrade.setDate(new Date("2018/4/7"));
        tempGrade.setCourse(new Course(54, "Fizyka", "Jan Nowak"));
        grades.add(tempGrade);
        tempGrade = new Grade();
        //
        tempGrade.setId(12);
        tempGrade.setValue(5);
        tempGrade.setDate(new Date("2018/4/8"));
        tempGrade.setCourse(new Course(59, "Chemia", "Piotr Kwiatkowski"));
        grades.add(tempGrade);
        tempGrade = new Grade();
        //
        student = new Student(106, "Piotr", "Wróbel", new Date("1995/8/16"), grades);
        students.add(student);
        grades =  new ArrayList<>();
        /////////// student 3
        tempGrade.setId(6);
        tempGrade.setValue(3.5f);
        tempGrade.setDate(new Date("2018/4/9"));
        tempGrade.setCourse(new Course(54, "Matematyka", "Jan Kowalski"));
        grades.add(tempGrade);
        tempGrade = new Grade();
        //
        tempGrade.setId(80);
        tempGrade.setValue(2.0f);
        tempGrade.setDate(new Date("2018/4/7"));
        tempGrade.setCourse(new Course(54, "Fizyka", "Jan Nowak"));
        grades.add(tempGrade);
        tempGrade = new Grade();
        //
        tempGrade.setId(13);
        tempGrade.setValue(5);
        tempGrade.setDate(new Date("2018/4/8"));
        tempGrade.setCourse(new Course(59, "Chemia", "Piotr Kwiatkowski"));
        grades.add(tempGrade);
        tempGrade = new Grade();
        //
        student = new Student(107, "Maciej", "Wiśniewski", new Date("1994/9/18"), grades);
        students.add(student);
        grades =  new ArrayList<>();
    }

    public mockModel() {
    }

    public static List<Student> getStudentsList() {
        return students;
    }
}