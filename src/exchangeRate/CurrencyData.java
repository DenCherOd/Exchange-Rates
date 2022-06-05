package exchangeRate;

public class CurrencyData {
    private final String date;
    private final String time;
    private final int digitalCode;
    private final String letterCode;
    private final int unit;
    private final String currencyName;
    private final String uah;

    public CurrencyData(String date, String time, int digitalCode, String letterCode, int unit, String currencyName, String uah) {
        this.date = date;
        this.time = time;
        this.digitalCode = digitalCode;
        this.letterCode = letterCode;
        this.unit = unit;
        this.currencyName = currencyName;
        this.uah = uah;
    }
}