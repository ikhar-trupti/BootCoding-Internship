package org.example.model;

import java.util.*;

public class Functionality {
    private HashMap<Integer, Student> map = new HashMap<>();

    public void addStudent(Student student) {
        map.put(student.getRollNum(), student);
    }

    public void printAllStudentsInformation() {
        System.out.println("All Students Information");
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            Integer rollNum = entry.getKey();
            Student student = entry.getValue();
            System.out.println("Roll number:" + student.getRollNum() + "|| Name:" + student.getName() +
                    "|| Grade:" + student.getGrade() + "|| GPA:" + student.getGPA());
        }
    }

    public void searchUsingRollNumber(int rollNumber) {
        if (map.containsKey(rollNumber)) {
            Student student = map.get(rollNumber);
            System.out.println("Student found by roll number");
            System.out.println("Roll number:" + student.getRollNum() + "|| Name:" + student.getName() +
                    "|| Grade:" + student.getGrade() + "|| GPA:" + student.getGPA());

        } else {
            System.out.println("Student not found");
        }
    }

    public void searchUsingName(String name) {
        boolean isFound = false;
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            Student student = entry.getValue();
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student Found by name");
                System.out.println("Roll number:" + student.getRollNum() + "|| Name:" + student.getName() +
                        "|| Grade:" + student.getGrade() + "|| GPA:" + student.getGPA());
                isFound = true;
                break;
            }
        }
        if (!isFound) System.out.println("Student not found");
    }

    public void searchUsingGrade(char grade) {
        boolean isFound = false;
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            Student student = entry.getValue();
            if (student.getGrade() == grade) {
                System.out.println("Student Found by grade");
                System.out.println("Roll number:" + student.getRollNum() + "|| Name:" + student.getName() +
                        "|| Grade:" + student.getGrade() + "|| GPA:" + student.getGPA());
                isFound = true;
            }

        }
        if (!isFound) System.out.println("Student not found");
    }

    public void updateName(int rollNum, String newName) {
        Student student = map.get(rollNum);
        student.setName(newName);
        System.out.println("Updated Successfully");
    }

    public void updateGrade(int rollNum, char newGrade) {
        Student student = map.get(rollNum);
        student.setGrade(newGrade);
        System.out.println("Updated Successfully");
    }

    public void removeStudent(int rollNumber) {
        map.remove(rollNumber);
    }

    public void sortingUsingGPA(double GPA) {
        List<Student> list = new ArrayList<>();
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            if (entry.getValue().getGPA() >= GPA) {
                list.add(entry.getValue());
            }
        }

        Collections.sort(list, Comparator.comparingDouble(Student::getGPA));
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println("Roll number:" + student.getRollNum() + "|| Name:" + student.getName() +
                    "|| Grade:" + student.getGrade() + "|| GPA:" + student.getGPA());
        }


    }

    public void sortingUsingGPA(double fromGPA, double toGPA) {
        List<Student> list = new ArrayList<>();

        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            Student student = entry.getValue();
            if (student.getGPA() >= fromGPA && student.getGPA() <= toGPA) {
                list.add(entry.getValue());
            }
        }

        Collections.sort(list, Comparator.comparingDouble(Student::getGPA));
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println("Roll number:" + student.getRollNum() + "|| Name:" + student.getName() +
                    "|| Grade:" + student.getGrade() + "|| GPA:" + student.getGPA());
        }


    }
}
