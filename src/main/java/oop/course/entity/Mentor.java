package oop.course.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Mentor extends Person{
    private int experience; // total months
    private int cabinet;
    private Subject subject;

    public Mentor(String courseName, String fullName, String address, String phoneNumber, int experience, int cabinet, Subject subject) {
        super(courseName, fullName, address, phoneNumber);
        this.experience = experience;
        this.cabinet = cabinet;
        this.subject = subject;
    }
}
