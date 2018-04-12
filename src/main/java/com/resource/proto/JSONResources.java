package com.resource.proto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JSONResources {

//    List<Student> students = mockModel.getStudentsList();

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
    public Student getStudent(@PathParam("studentId") long id) {
        return studentService.getStudent(id);
    }

//  ==================================================
//                      COURSES
//  ==================================================


    CourseService courseService = new CourseService();

    @GET
    @Path("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @POST
    @Path("/courses")
    public Response addCourse(Course course) {
        Course newCourse = courseService.addCourse(course);
        return Response.status(Response.Status.CREATED).entity(newCourse).build();
    }

    @PUT
    @Path("/courses/{courseId}")
    public Course updateCourse(@PathParam("courseId") long id, Course course) {
        course.setId(id);
        return courseService.updateCourse(course);
    }

    @DELETE
    @Path("/courses/{courseId}")
    public void deleteCourse(@PathParam("courseId") long id) {
        courseService.removeCourse(id);
    }

    @GET
    @Path("/courses/{courseId}")
    public Course getCourse(@PathParam("courseId") long id) {
        return courseService.getCourse(id);
    }

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
        courseService.addCourse(grade.getCourse());
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
