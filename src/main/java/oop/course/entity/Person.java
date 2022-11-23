package oop.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {
    private String courseName;
    private String fullName;
    private String address;
    private String phoneNumber;
}
