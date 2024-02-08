package org.example.bootcoding.service;

import org.example.bootcoding.model.Assignment;

import java.util.ArrayList;
import java.util.List;

public class AssignmentService {
    public List<Assignment> readFile(String filename){
        List<Assignment> assignmentList = new ArrayList<>();
        CSVFileReader csvFileReader = new CSVFileReader();
        List<String> recordData = csvFileReader.read(filename);

        for (String record:
             recordData) {
            Assignment assignment = convertToAssignment(record);
            assignmentList.add(assignment);
        }
        return assignmentList;
    }

    private Assignment convertToAssignment(String record) {
//        1,Two Sum,two-sum,Easy,51.76576548830185,False,"array,hash-table",algorithms
        String[] splitResult = record.split(",");
        double acceptanceRate ;
       try {
           acceptanceRate = Double.parseDouble(splitResult[4]);
       }catch (NumberFormatException exception){
           acceptanceRate = 0.0d;
       }
       return new Assignment(Integer.parseInt(splitResult[0]), splitResult[1], splitResult[3],
               acceptanceRate, Boolean.parseBoolean(splitResult[5]));

    }

    public void convertToJson(List<Assignment> object){
        JSONFileWriter jsonFileWriter = new JSONFileWriter();
        jsonFileWriter.write(object);
    }
}
