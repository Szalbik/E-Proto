package com.resource.proto;

import com.mongodb.WriteResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/courses")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CourseResources {
    CourseService courseService = new CourseService();

    @GET
    public List<Course> getCourses() {
        List<Course> courses = courseService.getCourses();
        return courses;
    }

    @POST
    public Response addCourse(Course course) {
        Course newCourse = courseService.addCourse(course);
        return Response.status(Response.Status.CREATED).header("Location", "/courses/" + course.getId()).entity(newCourse).build();
    }

    @PUT
    @Path("/{id}")
    public Course updateCourse(@PathParam("id") long id, Course course) {
//        course.setId(id);
        return courseService.updateCourse(id, course);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCourse(@PathParam("id") long id) {
        Course course = courseService.removeCourse(id);

        if (course != null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Path("/{id}")
    public Course getCourse(@PathParam("id") long id) {
        return courseService.getCourse(id);
    }
}

