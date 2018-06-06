package com.resource.proto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.resource.proto.Grade;
import org.bson.types.ObjectId;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

@Entity("students")
@XmlRootElement
public class Student {
    @XmlTransient
    @Id
    @XmlJavaTypeAdapter(ObjectIdJaxbAdapter.class)
    private ObjectId id;
    private long index;
    private String firstName;
    private String lastName;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "CET")
    private Date birthDate;
    @Embedded
    private List<Grade> grades;
    @InjectLinks({
            @InjectLink(value = "/students/{index}", rel = "self"),
            @InjectLink(value = "/students", rel = "parent"),
            @InjectLink(value = "/students/{index}/grades", rel = "grades")
    })
    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links;

    public Student() {}

    public Student(long index, String firstName, String lastName, Date birthDate) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Student(long index, String firstName, String lastName, Date birthDate, Map<Long, Grade> grades) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
//        this.grades = grades;
    }

    @XmlTransient
    @XmlElement
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @XmlElement
    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = new Date(birthDate);
    }

    @XmlElement
    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
