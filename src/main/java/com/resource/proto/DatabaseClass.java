package com.resource.proto;

import org.mongodb.morphia.Datastore;

import java.util.*;

public class DatabaseClass {
    private static Map<Long, Student> students = new HashMap<>();
    private static Map<Long, Course> courses = new HashMap<>();
    private static Map<Long, Grade> grades = new HashMap<>();

    static {
//        Datastore datastore = MorphiaDatabase.getDatabase().getDatastore();

        Grade tempGrade1 = new Grade();
        /////////// student 1
        tempGrade1.setId(1);
        tempGrade1.setValue(4);
        tempGrade1.setDate(new Date("2018/4/9"));
        tempGrade1.setCourse(new Course(3322, "Fizyka", "Jan Nowak"));
        grades.put(1l, tempGrade1);
        //
        Grade tempGrade2 = new Grade();
        tempGrade2.setId(14);
        tempGrade2.setValue(3);
        tempGrade2.setDate(new Date("2018/4/7"));
        tempGrade2.setCourse(new Course(32, "Fizyka", "Jan Nowak"));
        grades.put(2l, tempGrade2);
        tempGrade2 = new Grade();
        //
        Grade tempGrade3 = new Grade();
        tempGrade3.setId(3);
        tempGrade3.setValue(5);
        tempGrade3.setDate(new Date("2018/4/8"));
        tempGrade3.setCourse(new Course(3, "Chemia", "Piotr Kwiatkowski"));
        grades.put(3l, tempGrade3);
        tempGrade3 = new Grade();
        //
        Student student = new Student(1, "Damian" + new Random().nextInt(), "Szalbierz", new Date("1995/2/15"));
        students.put(1l, student);
        grades = new HashMap<Long, Grade>();
        /////////// student 2
        Grade tempGrade4 = new Grade();
        tempGrade4.setId(4);
        tempGrade4.setValue(4);
        tempGrade4.setDate(new Date("2018/4/9"));
        tempGrade4.setCourse(new Course(4, "Angielski", "Jadwiga Kowalska"));
        grades.put(4l, tempGrade4);
        //
        Grade tempGrade5 = new Grade();
        tempGrade5.setId(5);
        tempGrade5.setValue(3);
        tempGrade5.setDate(new Date("2018/4/7"));
        tempGrade5.setCourse(new Course(5, "Fizyka", "Jan Nowak"));
        grades.put(5l, tempGrade5);
        tempGrade5 = new Grade();
        //
        Grade tempGrade6 = new Grade();
        tempGrade6.setId(6);
        tempGrade6.setValue(5);
        tempGrade6.setDate(new Date("2018/4/8"));
        tempGrade6.setCourse(new Course(6, "Chemia", "Piotr Kwiatkowski"));
        grades.put(6l, tempGrade6);
        tempGrade6 = new Grade();
        //
        Student student2 = new Student(2, "Kuba", "Szalbierz", new Date("1995/2/15"));
        students.put(2l, student2);
        grades = new HashMap<Long, Grade>();

        courses.put(1l, new Course(1, "Learn Rest Api", "Janosik"));
        courses.put(2l, new Course(2, "Learn WSDL ", "Marciniak"));

        List<Student> studentsList = new ArrayList<Student>(students.values());
        List<Course> coursrsList = new ArrayList<Course>(courses.values());

//        List<Course> dsadasdasd = datastore.createQuery(Course.class).asList();
//        System.out.println(dsadasdasd);
    }


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
