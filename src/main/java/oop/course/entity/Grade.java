package oop.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Grade {
    private long studentId;
    private Subject subject;
    private int grade; // 0-bad, 90-ok, but can be better, 100- excellent
}
