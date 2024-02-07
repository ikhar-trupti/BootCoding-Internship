package org.example.model;

import lombok.Data;

@Data
public class Student {

    private int rollNum;
    private String name;
    private char grade;
    private double GPA;

    public Student(int rollNum, String name, char grade, double GPA) {
        this.rollNum = rollNum;
        this.name = name;
        this.grade = grade;
        this.GPA = GPA;
    }


}
