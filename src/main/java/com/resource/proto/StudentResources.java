package com.resource.proto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class StudentResources {
    StudentService studentService = new StudentService();

    @GET
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @POST
    public Response addStudent(Student student) {
        Student newStudent = studentService.addStudent(student);
        return Response.status(Response.Status.CREATED).entity(newStudent).build();
    }

    @PUT
    @Path("/{index}")
    public Student updateStudent(@PathParam("index") long index, Student student) {
//        student.setIndex(id);
        return studentService.updateStudent(index, student);
    }

    @DELETE
    @Path("/{index}")
    public void deleteStudent(@PathParam("index") long id) {
        studentService.removeStudent(id);
    }

    @GET
    @Path("/{index}")
    public Response getStudent(@PathParam("index") long index) {
        if (studentService.getStudent(index) == null) {
            return Response.status(404).build();
        }

        Student student = studentService.getStudent(index);
        return Response.status(200).entity(student).build();
    }

    @Path("/{index}/grades")
    public GradeResource getGradeResource() {
        return new GradeResource();
    }
}
