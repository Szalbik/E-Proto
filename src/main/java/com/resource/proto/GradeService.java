package com.resource.proto;

import com.mongodb.WriteResult;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.*;

public class GradeService {
    private Map<Long, Student> students = DatabaseClass.getStudents();

    private Datastore datastore = MorphiaDatabase.getDatabase().getDatastore();
    final Query<Grade> queryGrade = datastore.createQuery(Grade.class);
    final Query<Student> queryStudent = datastore.createQuery(Student.class);
    final Query<Course> queryCourse = datastore.createQuery(Course.class);


    public List<Grade> getGrades(long index) {
        Student foundStudent = queryStudent.field("index").equal(index).get();
        List<Grade> grades = foundStudent.getGrades();
        return grades;
    }

    public Grade getGrade(long index, long gradeId) {
        Student foundStudent = queryStudent.field("index").equal(index).get();
        List<Grade> grades = foundStudent.getGrades();
//        Optional<Grade> gradeMatch = grades.stream()
//                .filter(g -> g.getId() == gradeId).findFirst();
//        return gradeMatch.get();
        for (Grade grade:grades) {
            if(gradeId == grade.getId()) {
                return grade;
            }
        }
        Grade grade = new Grade();
        return grade;
    }
//
    public Grade addGrade(long studentIndex, Grade grade) {
        Student foundStudent = queryStudent.field("index").equal(studentIndex).get();
        if (foundStudent.getGrades() != null) {
            grade.setId(foundStudent.getGrades().size() + 1);
        } else {
            grade.setId(1);
        }

        long courseId = grade.getCourse().getId();
        Course course = queryCourse.field("id").equal(courseId).get();
        grade.setCourse(course);

        List<Grade> foundStudentGrades = foundStudent.getGrades();

        UpdateOperations ops;
        if(foundStudentGrades != null) {
            foundStudentGrades.add(grade);
            ops = datastore
                    .createUpdateOperations(Student.class)
                    .set("grades", foundStudentGrades);
        } else {
            List<Grade> grades = new ArrayList<>();
            grades.add(grade);
            ops = datastore
                    .createUpdateOperations(Student.class)
                    .set("grades", grades);
        }

        datastore.update(foundStudent, ops);
        return grade;
    }

    public Grade updateGrade(long studentIndex, long gradeId, Grade grade) {
        Student foundStudent = queryStudent.field("index").equal(studentIndex).get();
        List<Grade> grades = foundStudent.getGrades();

        UpdateOperations ops;
        if(grades != null) {

            if (grades.stream().anyMatch(g -> g.getId() == gradeId)) {

                for (Grade g:grades) {
                    if(g.getId() == gradeId) {
                        g.setValue(grade.getValue());
                        g.setDate(grade.getDate());
                        g.setCourse(grade.getCourse());
                    }
                }

            } else {
                grade.setId(grades.size() + 1);
                grades.add(grade);
            }
            ops = datastore
                    .createUpdateOperations(Student.class)
                    .set("grades", grades);

        } else {
            List<Grade> newGrades = new ArrayList<>();
            grade.setId(gradeId);
            newGrades.add(grade);
            ops = datastore
                    .createUpdateOperations(Student.class)
                    .set("grades", newGrades);
        }
        datastore.update(foundStudent, ops);

        return grade;
    }

    public void removeGrade(long studentIndex, long gradeId) {
        Student foundStudent = queryStudent.field("index").equal(studentIndex).get();
        List<Grade> foundStudentGrades = foundStudent.getGrades();

        UpdateOperations ops;
        if(foundStudentGrades != null) {
            Iterator<Grade> iter = foundStudentGrades.iterator();
            while (iter.hasNext()) {
                Grade grade = iter.next();
                if (gradeId == grade.getId())
                    iter.remove();
            }

            ops = datastore
                    .createUpdateOperations(Student.class)
                    .set("grades", foundStudentGrades);

        } else {
            List<Grade> grades = new ArrayList<>();
            ops = datastore
                    .createUpdateOperations(Student.class)
                    .set("grades", grades);
        }
        datastore.update(foundStudent, ops);
    }
}
