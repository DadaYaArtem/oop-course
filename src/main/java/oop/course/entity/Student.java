package oop.course.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends Person{
    private long studentId;
    private List<Grade> grades;

    public Student(long studentId, String courseName, String fullName, String address, String phoneNumber,List<Grade> grades) {
        super(courseName, fullName, address, phoneNumber);
        this.studentId = studentId;
        this.grades = grades;
    }
}
