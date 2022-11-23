package oop.course.service;

import oop.course.entity.Grade;
import oop.course.entity.Mentor;
import oop.course.entity.Student;
import oop.course.entity.Subject;
import oop.course.storage.Storage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    Storage storage;
    List<Student> students;
    List<Mentor> mentors;

    public Service() throws FileNotFoundException {
        storage = new Storage();
        storage.initStorage();

        students = storage.getStudents();
        mentors = storage.getMentors();
    }

    public int getStudentsAmount(){
        return students.size();
    }

    public int getMentorsAmount(){
        return mentors.size();
    }

    public double averageGradeBySubject(Subject subject){
        List<Integer> allGrades = new ArrayList<>();
        for (Student student : students) {
            List<Integer> grades = student.getGrades().stream()
                    .filter(it -> it.getSubject().equals(subject))
                    .map(Grade::getGrade)
                    .toList();

            allGrades.addAll(grades);
        }
        return allGrades.stream().mapToDouble(a -> a).average().getAsDouble();
    }

    public int countExcellentStudents(){
        int count = 0;
        for (Student student : students) {
            double average = student.getGrades().stream()
                    .map(Grade::getGrade)
                    .mapToDouble(it -> it)
                    .average().getAsDouble();

            if (average >= 90){
                count++;
            }
        }

        return count;
    }

    public int countLoserStudents(){
        int count = 0;
        for (Student student : students) {
            double average = student.getGrades().stream()
                    .map(Grade::getGrade)
                    .mapToDouble(it -> it)
                    .average().getAsDouble();

            if (average <= 90){
                count++;
            }
        }
        return count;
    }

    public double avgExperience(){
        return mentors.stream().map(Mentor::getExperience).mapToDouble(it -> it).average().getAsDouble();
    }

    public void printTable(){
        System.out.println("Choose a number of the request you want to execute: \n" +
                "1. Amount of mentors \n" +
                "2. Amount of students\n" +
                "3. Average grade by subject\n" +
                "4. Amounts of excellent students\n" +
                "5. Average experience of mentors (in months)\n" +
                "6. Amount of not perfect students \n" +
                "(Print 'q' to exit)"
        );
    }
}
