import oop.course.entity.Subject;
import oop.course.service.Service;
import oop.course.storage.Storage;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Storage storage = new Storage();
        Service service = new Service();
        Scanner in = new Scanner(System.in);
        storage.initStorage();

        String req;
        System.out.println("Hello, Welcome to the program! ");
        while (true) {
            service.printTable();
            req = in.nextLine();

            switch (req) {
                case "q" -> System.exit(0);
                case "1" -> System.out.println("Amount of mentors: " + service.getMentorsAmount() + "\n");
                case "2" -> System.out.println("Amount of students: " + service.getStudentsAmount() + "\n");
                case "3" -> {
                    System.out.println("Select subject you want to get avg grade: ");
                    String subj = in.nextLine();
                    try {
                        System.out.println("Amount grade in " + subj + " is: " + service.averageGradeBySubject(Subject.valueOf(subj.toUpperCase())) + "\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println("No such subject\n");
                    } catch (NoSuchElementException e) {
                        System.out.println("No grades in this subject yet\n");
                    }
                }
                case "4" -> System.out.println("Amount of excellent students: " + service.countExcellentStudents() + "\n");
                case "5" -> System.out.println("Average experience of mentors: " + service.avgExperience() + "\n");
                case "6" -> System.out.println("Amount of not perfect students: " + service.countLoserStudents() + "\n");

                default -> System.out.println("Unexpected value: " + req + "\n");
            }
        }
    }
}
