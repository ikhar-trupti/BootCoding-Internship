import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FileHandlingTask2 {
    public static void writeInFile(String outputFile , ArrayList <String> contentList){
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            for(int i = 0 ; i < contentList.size(); i++){
                fileWriter.write(contentList.get(i)+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        File inputFile = new File("export.csv");
        try {
            Scanner sc = new Scanner(inputFile);
            sc.useDelimiter(",");
            sc.nextLine();
            // creating hashmap with continent name as a key and (number of countries in a )list as a value.
            HashMap<String, ArrayList<String>> map = new HashMap<>();

            while(sc.hasNextLine()){
                String content = sc.nextLine();
                String parts[] = content.split(",");
                String outputFileName = parts[3]+".csv";

                // if outputfile already exists then changes will be in existing outputFile
                // otherwise outputfile will be created

                if ( !map.isEmpty() && map.containsKey(outputFileName)){
                    ArrayList <String> contentList = map.get(outputFileName);
                    contentList.add(content);
                    writeInFile(outputFileName,contentList);
                }else {
                    map.put(outputFileName,new ArrayList<>(Arrays.asList(content)));
                    File file = new File(outputFileName);
                    file.createNewFile();
                    writeInFile(outputFileName,map.get(outputFileName));
                }


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
