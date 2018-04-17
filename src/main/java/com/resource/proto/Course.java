package com.resource.proto;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement
public class Course {
    private long id;
    private String name;
    private String lecturer;
    @InjectLinks({
            @InjectLink(value = "/courses/{id}", rel = "self"),
            @InjectLink(value = "/courses", rel = "parent"),
//            @InjectLink(value = "/students/{index}", rel = "student")
    })
    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links;

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
