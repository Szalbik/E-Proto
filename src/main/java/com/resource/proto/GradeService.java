package com.resource.proto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GradeService {
    private Map<Long, Grade> grades = DatabaseClass.getGrades();

    public List<Grade> getGrades() {
        return new ArrayList<Grade>(grades.values());
    }

    public Grade getGrade(long id) {
        return grades.get(id);
    }

    public Grade addGrade(Grade grade) {
        grade.setId(grades.size() + 1);
        grades.put(grade.getId(), grade);
        return grade;
    }

    public Grade updateGrade(Grade grade) {
        if (grade.getId() <= 0) {
            return null;
        }
        grades.put(grade.getId(), grade);
        return grade;
    }

    public Grade removeGrade(long id) {
        return grades.remove(id);
    }
}
