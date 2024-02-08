package org.example;

import org.example.bootcoding.service.AssignmentService;

public class Main {
    public static void main(String[] args) {
        AssignmentService assignmentService = new AssignmentService();
        assignmentService.convertToJson(assignmentService.readFile("C:\\Users\\aniket\\java_worksplace" +
                "\\CSVtoJsonTask\\src\\main\\java\\org\\example\\bootcoding\\service\\ques.csv"));


    }
}