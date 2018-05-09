package com.resource.proto;

import com.mongodb.WriteResult;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;
import java.util.Map;

public class CourseService {
    private Map<Long, Course> courses = DatabaseClass.getCourses();

    private Datastore datastore = MorphiaDatabase.getDatabase().getDatastore();
    final Query<Course> query = datastore.createQuery(Course.class);

    public CourseService() {}

    public List<Course> getCourses() {
        List<Course> courseList = query.asList();
        return courseList;
    }

    public Course getCourse(long id) {
        Course course = query.field("id").equal(id).get();
        return course;
    }

    public Course addCourse(Course course) {
        course.setId(courses.size() + 1);
        courses.put(course.getId(), course);
        datastore.save(course);
        return course;
    }

    public Course updateCourse(Course course) {
        if (course.getId() <= 0) {
            return null;
        }

        Course foundCourse = query.field("id").equal(course.getId()).get();
        UpdateOperations ops = datastore
                .createUpdateOperations(Course.class)
                .set("name", course.getName())
                .set("lecturer", course.getLecturer());

        datastore.update(foundCourse, ops);

        return course;
    }

    public WriteResult removeCourse(long id) {
        Course foundCourse = (Course) query.field("id").equal(id).get();
        return datastore.delete(foundCourse);
    }
}
