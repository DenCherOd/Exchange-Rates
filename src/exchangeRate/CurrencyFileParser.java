package exchangeRate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrencyFileParser {

    List<CurrencyData> currencyDataList= new ArrayList<>();

    public void getDataFromFile(String currency) throws IOException {
        List<File> allFiles = listFilesForFolder(new File(System.getProperty("user.dir") + "/src/files"));
        currencyDataList = new ArrayList<>();
        for (File file : allFiles) {
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                br.readLine();
                line = br.readLine();
                while (line != null) {
                    String[] currencyAfterParsing = line.split("|");
                    for (String currencyInfo : currencyAfterParsing) {
                        if (currencyInfo == currency) {
                            currencyDataList.add(new CurrencyData(currencyAfterParsing[0], currencyAfterParsing[1], Integer.valueOf(currencyAfterParsing[2]),
                                    currencyAfterParsing[3], Integer.valueOf(currencyAfterParsing[4]), currencyAfterParsing[5], currencyAfterParsing[6]));


//                            fr.close();
                        }


                    }
                }
            }
        }
    }

    public void getDataFromFileByDate(String currency, List<String> days) {


    }

    public List<File> listFilesForFolder(File folder) {
        List<File> files = new ArrayList<>();
        for (File fileEntry : folder.listFiles()) {
            files.add(fileEntry);
        }
        return files;
    }
}