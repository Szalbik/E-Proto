package com.resource.proto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.resource.proto.Course;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Embedded
@XmlRootElement
public class Grade {
    private long id;
    private float value;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date date;
    @Reference
    private Course course;

    public Grade() {}

    public Grade(long id, float value, Date date) {
        this.id = id;
        this.value = value;
        this.date = date;
    }

    public Grade(long id, float value, Date date, Course course) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        if (value%0.5f == 0 && (value >= 3f && value <= 5f) || value == 2f) {
            this.value = value;
        } else {
            this.value = 2f;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
