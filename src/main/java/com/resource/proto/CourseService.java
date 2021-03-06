package com.resource.proto;

import com.mongodb.WriteResult;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;
import java.util.Map;

public class CourseService {
//    private Map<Long, Course> courses = DatabaseClass.getCourses();

    private Datastore datastore = MorphiaDatabase.getDatabase().getDatastore();
    final Query<Course> query = datastore.createQuery(Course.class);

    public List<Course> getCourses(String name, String lecturer) {
        if (name != null) {
            query.field("name").containsIgnoreCase(name);
        }

        if (lecturer != null) {
            query.field("lecturer").containsIgnoreCase(lecturer);
        }

        return query.asList();
    }

    public Course getCourse(long id) {
        Course course = query.field("id").equal(id).get();
        return course;
    }

    public Course addCourse(Course course) {
        course.setId(query.asList().size() + 1);
        datastore.save(course);
        return course;
    }

    public Course updateCourse(long id, Course course) {
        if (course.getId() <= 0) {
            return null;
        }

        Course foundCourse = query.field("id").equal(id).get();
        UpdateOperations ops = datastore
                .createUpdateOperations(Course.class)
                .set("name", course.getName())
                .set("lecturer", course.getLecturer());

        datastore.update(foundCourse, ops);

        return course;
    }

    public Course removeCourse(long id) {
        Course foundCourse = (Course) query.field("id").equal(id).get();
        if (foundCourse != null) {
            datastore.delete(foundCourse);
            return foundCourse;
        } else {
            return null;
        }
    }
}
