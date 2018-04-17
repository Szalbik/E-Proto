package com.resource.proto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseService {
    private Map<Long, Course> courses = DatabaseClass.getCourses();

    public CourseService() {}

    public List<Course> getCourses() {
        return new ArrayList<Course>(courses.values());
    }

    public Course getCourse(long id) {
        return courses.get(id);
    }

    public Course addCourse(Course course) {
        course.setId(courses.size() + 1);
        courses.put(course.getId(), course);
        return course;
    }

    public Course updateCourse(Course course) {
        if (course.getId() <= 0) {
            return null;
        }
        courses.put(course.getId(), course);
        return course;
    }

    public Course removeCourse(long id) {
        return courses.remove(id);
    }
}
