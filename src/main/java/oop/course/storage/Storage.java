package oop.course.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import oop.course.entity.Mentor;
import oop.course.entity.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Data
public class Storage {
    private List<Mentor> mentors;
    private List<Student> students;

    public List<Mentor> getMentors() {
        return new ArrayList<>(mentors);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void initStorage() throws FileNotFoundException {
        BufferedReader stud = new BufferedReader(new FileReader("src/main/resources/students.json"));
        BufferedReader ment = new BufferedReader(new FileReader("src/main/resources/mentors.json"));

        Type listTypeStudent = new TypeToken<List<Student>>() {}.getType();
        Type listTypeMentor = new TypeToken<List<Mentor>>() {}.getType();

        students = new Gson().fromJson(stud, listTypeStudent);
        mentors = new Gson().fromJson(ment, listTypeMentor);
    }
}
