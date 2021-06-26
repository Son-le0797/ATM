package data;

import model.Customer;
import model.Exchangement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerData {

    public static void writefile(String pathFile, String line) {

        try {

            FileWriter fileWriter = new FileWriter(pathFile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String pathFile) {
        List<String> listLine = new ArrayList<>();

        try {


            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLine;
    }

}
