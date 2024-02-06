import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingTask {
    public static void writeInFile(String fileName , String str2){
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(str2);
            fw.close();
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
            while(sc.hasNextLine()){
                String str2 = sc.nextLine();
                String parts[] = str2.split(",");

                File temp = new File(parts[2]+".csv");
                temp.createNewFile();
                writeInFile(parts[2]+".csv",str2);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
