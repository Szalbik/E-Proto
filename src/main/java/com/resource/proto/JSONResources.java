package com.resource.proto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class JSONResources {


    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return StudentService.getAllStudents();
    }

    @GET
    @Path("/courses")
    @Produces(MediaType.APPLICATION_JSON)
    public Course getCourses(long id) {
        return new Course();
    }

    @POST
    @Path("/courses")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCourse(Course course) {

        return Response.status(201).build();
    }

}
