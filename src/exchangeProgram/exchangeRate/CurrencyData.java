package exchangeProgram.exchangeRate;

public class CurrencyData {
    private final String date;
    private final String time;
    private final Integer digitalCode;
    private final String letterCode;
    private final Integer unit;
    private final String currencyName;
    private final Integer uah;

    public String getLetterCode() {
        return letterCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public Integer getUah() {
        return uah;
    }

    public CurrencyData(String date, String time, Integer digitalCode, String letterCode, Integer unit, String currencyName, Integer uah) {
        this.date = date;
        this.time = time;
        this.digitalCode = digitalCode;
        this.letterCode = letterCode;
        this.unit = unit;
        this.currencyName = currencyName;
        this.uah = uah;
    }
}