package data;

import model.Exchangement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExchangementData {

    ArrayList<Exchangement> exchangements;
//    public static int count = 1;
//    public static final String PATH = "list_exchangement.csv";
//
//    public ExchangementData() {
//        exchangements = new ArrayList<>();
//    }
//
//    public void writeFile() throws IOException {
//        File file = new File(PATH);
//        if(!file.exists()){
//            file.createNewFile();
//        }
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
//        for(Exchangement exchangement : exchangements) {
//            bufferedWriter.write(exchangement.toStringCSV2());
//        }
//        bufferedWriter.close();
//    }
//
//    public void readFile() throws IOException{
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] arr = line.split(",");
//
//        }
//    }
//
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

            while ((line =bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLine;
    }

}
