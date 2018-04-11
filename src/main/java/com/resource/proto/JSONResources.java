package com.resource.proto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class JSONResources {

//    List<Student> students = mockModel.getStudentsList();
    StudentService studentService = new StudentService();

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GET
    @Path("/students/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("studentId") long id) {
        return studentService.getStudent(id);
    }

//    @GET
//    @Path("/students")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Student> getStudents() {
//        return students;
//    }
//
//    @POST
//    @Path("/students")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createCourse(Student student) {
//        students.add(student);
//        return Response.status(201).build();
//    }
//

    CourseService courseService = new CourseService();

    @GET
    @Path("/courses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses() {
        return courseService.getCourses();
    }
//
//    @POST
//    @Path("/courses")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createCourse(Course course) {
//
//        return Response.status(201).build();
//    }

}
