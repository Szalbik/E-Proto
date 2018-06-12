package com.resource.proto;

import com.sun.istack.internal.Nullable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;

@Path("/")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class GradeResource {
    GradeService gradeService = new GradeService();

    @GET
    public Response getGrades(@PathParam("index") long studentId,
                              @QueryParam("value") Float value,
                              @QueryParam("date") Date date) {
        List<Grade> gradeList = gradeService.getGrades(studentId, value, date);
        return Response.status(Response.Status.OK).entity(gradeList).build();
    }

    @POST
    public Response addGrade(@PathParam("index") long studentId, Grade grade) {
        Grade newGrade = gradeService.addGrade(studentId, grade);
        return Response.status(Response.Status.CREATED).entity(newGrade).build();
    }

    @PUT
    @Path("/{gradeId}")
    public Grade updateGrade(@PathParam("index") long studentId, @PathParam("gradeId") long gradeId, Grade grade) {
        return gradeService.updateGrade(studentId, gradeId, grade);
    }

    @DELETE
    @Path("/{gradeId}")
    public void deleteGrade(@PathParam("index") long studentId, @PathParam("gradeId") long gradeId) {
        gradeService.removeGrade(studentId, gradeId);
    }

    @GET
    @Path("/{gradeId}")
    public Response getGrade(@PathParam("index") long studentId, @PathParam("gradeId") long gradeId) {
        Grade grade = gradeService.getGrade(studentId, gradeId);
        if (grade.getId() != gradeId) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(grade).build();
    }
}
