package com.resource.proto;

public class Course {
    private long id;
    private String name;
    private String lecturer;

    public Course() {}

    public Course(long id, String name, String lecturer) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
}
