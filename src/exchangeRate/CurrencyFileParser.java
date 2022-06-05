package exchangeRate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CurrencyFileParser {

    private CurrencyData currencyData;

    public HashMap<String, HashMap<String, CurrencyData>> getDataFromFile(String currency) throws IOException {
        List<File> allFiles = listFilesForFolder(new File(System.getProperty("user.dir") + "/src/files"));
        HashMap<String, CurrencyData> currencyDataBy = new HashMap<>();
        for (File file : allFiles) {
            while (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                br.readLine();
                line = br.readLine();
                while (line != null) {
                    String[] currencyAfterParsing = line.split("|");
                    for (String currencyInfo : currencyAfterParsing) {
                        if (currencyInfo == currency) {



//                            fr.close();
                        }


                    }
                }
            }
        }
        return null;
    }

    public HashMap<String, HashMap<String, CurrencyData>> getDataFromFileByDate(String currency, List<String> days) {

        return null;
    }

    public List<File> listFilesForFolder(File folder) {
        List<File> files = new ArrayList<>();
        for (File fileEntry : folder.listFiles()) {
            files.add(fileEntry);
        }
        return files;
    }
}