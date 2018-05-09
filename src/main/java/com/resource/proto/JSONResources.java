package com.resource.proto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class JSONResources {

//  ==================================================
//                      STUDENTS
//  ==================================================

    StudentService studentService = new StudentService();

    @GET
    @Path("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @POST
    @Path("/students")
    public Response addStudent(Student student) {
        Student newStudent = studentService.addStudent(student);
        return Response.status(Response.Status.CREATED).entity(newStudent).build();
    }

    @PUT
    @Path("/students/{studentId}")
    public Student updateStudent(@PathParam("studentId") long id, Student student) {
        student.setIndex(id);
        return studentService.updateStudent(student);
    }

    @DELETE
    @Path("/students/{studentId}")
    public void deleteStudent(@PathParam("studentId") long id) {
        studentService.removeStudent(id);
    }

    @GET
    @Path("/students/{studentId}")
    public Response getStudent(@PathParam("studentId") long id) {

        if (studentService.getStudent(id) == null) {
            return Response.status(404).build();
        }

        Student student = studentService.getStudent(id);
        return Response.status(200).entity(student).build();
    }

//  ==================================================
//                      COURSES
//  ==================================================

    CourseService courseService = new CourseService();

//  ==================================================
//                      GRADES
//  ==================================================

    GradeService gradeService = new GradeService();

    @GET
    @Path("/students/{studentId}/grades")
    public List<Grade> getGrades(@PathParam("studentId") long studentId) {
        return gradeService.getGrades(studentId);
    }

    @POST
    @Path("/students/{studentId}/grades")
    public Response addGrade(@PathParam("studentId") long studentId, Grade grade) {
        Grade newGrade =  gradeService.addGrade(studentId, grade);
//        courseService.addCourse(grade.getCourse());
        return Response.status(Response.Status.CREATED).entity(newGrade).build();
    }

    @PUT
    @Path("/students/{studentId}/grades/{gradeId}")
    public Grade updateGrade(@PathParam("studentId") long studentId, @PathParam("gradeId") long gradeId, Grade grade) {
        grade.setId(gradeId);
        return gradeService.updateGrade(studentId, grade);
    }

    @DELETE
    @Path("/students/{studentId}/grades/{gradeId}")
    public void deleteGrade(@PathParam("studentId") long studentId, @PathParam("gradeId") long gradeId) {
        gradeService.removeGrade(studentId, gradeId);
    }

    @GET
    @Path("/students/{studentId}/grades/{gradeId}")
    public Grade getGrade(@PathParam("studentId") long studentId, @PathParam("gradeId") long gradeId) {
        return gradeService.getGrade(studentId, gradeId);
    }

}
