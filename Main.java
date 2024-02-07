package org.example;

import org.example.model.Functionality;
import org.example.model.Student;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student(1, "Trupti Ikhar", 'A', 9.0);
        Student s2 = new Student(2, "Sakshi Waghmare", 'B', 7.8);
        Student s3 = new Student(3, "Aniket Ikhar", 'A', 6.0);


        Functionality f1 = new Functionality();
        f1.addStudent(s1);
        f1.addStudent(s2);
        f1.sortingUsingGPA(7.0,8.0);
        f1.printAllStudentsInformation();
        f1.searchUsingGrade('A');
        f1.searchUsingName("Trupti Ikhar");
        f1.searchUsingRollNumber(2);
        f1.removeStudent(2);
        f1.updateName(1,"Trippy");

    }
}