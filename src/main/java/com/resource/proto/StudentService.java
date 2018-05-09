package com.resource.proto;

import com.mongodb.WriteResult;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.*;

public class StudentService {
//    private Map<Long, Student> students = DatabaseClass.getStudents();

    private Datastore datastore = MorphiaDatabase.getDatabase().getDatastore();
    final Query<Student> query = datastore.createQuery(Student.class);

    public List<Student> getStudents() {
        return query.asList();
    }

    public Student getStudent(long id) {
        Query<Student> studentQuery = query.field("index").equal(id);
        return studentQuery.get();
    }

    public Student addStudent(Student student) {
        student.setIndex(query.asList().size() + 1);
//        students.put(student.getIndex(), student);
        datastore.save(student);
        return student;
    }

    public Student updateStudent(long index, Student student) {
        if (student.getIndex() <= 0) {
            return null;
        }

        Student foundStudent = query.field("index").equal(index).get();

        UpdateOperations ops = datastore
                .createUpdateOperations(Student.class)
                .set("firstName", student.getFirstName())
                .set("lastName", student.getLastName())
                .set("birthDate", student.getBirthDate());
//                .set("grades", student.getGrades());

        datastore.update(foundStudent, ops);

        return student;
    }

    public WriteResult removeStudent(long id) {
        Query<Student> studentQuery = query.field("index").equal(id);
        return datastore.delete(studentQuery.get());
    }
}
