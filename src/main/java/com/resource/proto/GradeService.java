package com.resource.proto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GradeService {
    private Map<Long, Student> students = DatabaseClass.getStudents();

    public List<Grade> getGrades(long studentIndex) {
        Map<Long, Grade> grades = students.get(studentIndex).getGrades();
        return new ArrayList<Grade>(grades.values());
    }

    public Grade getGrade(long studentIndex, long gradeId) {
        Map<Long, Grade> grades = students.get(studentIndex).getGrades();
        return grades.get(gradeId);
    }

    public Grade addGrade(long studentIndex, Grade grade) {
        Map<Long, Grade> grades = students.get(studentIndex).getGrades();
        grade.setId(grades.size() + 1);
        grades.put(grade.getId(), grade);
        return grade;
    }

    public Grade updateGrade(long studentIndex, Grade grade) {
        Map<Long, Grade> grades = students.get(studentIndex).getGrades();
        if (grade.getId() <= 0) {
            return null;
        }
        grades.put(grade.getId(), grade);
        return grade;
    }

    public Grade removeGrade(long studentIndex, long gradeId) {
        Map<Long, Grade> grades = students.get(studentIndex).getGrades();
        return grades.remove(gradeId);
    }
}
