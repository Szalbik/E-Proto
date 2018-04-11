package com.resource.proto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/* Root resource (exposed at "myresource" path) */
public class Student {
    long index;
    String firstName;
    String lastName;
    Date birthDate;
    List<Grade> grades;

    public Student() {}

    public Student(long index, String firstName, String lastName, Date birthDate) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Student(long index, String firstName, String lastName, Date birthDate, List<Grade> grades) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.grades = grades;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
