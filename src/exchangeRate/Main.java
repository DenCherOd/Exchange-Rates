package exchangeRate;

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        CurrencyDateScanner userTaskScanner = new CurrencyDateScanner();
        CurrencyFileParser cfp = new CurrencyFileParser();
        userTaskScanner.scanUserCurrency();

        HashMap<String, HashMap<String, CurrencyData>> currencyFromFiles = new HashMap<>();
        if(userTaskScanner.getDays().size() > 0){
            currencyFromFiles = cfp.getDataFromFileByDate(userTaskScanner.currencyLetterCode(), userTaskScanner.getDays());
        } else {
            currencyFromFiles = cfp.getDataFromFile(userTaskScanner.currencyLetterCode());
        }
    }
}