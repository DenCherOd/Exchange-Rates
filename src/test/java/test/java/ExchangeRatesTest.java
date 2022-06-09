package test.java;

import exchangeProgram.exchangeRate.CurrencyDateScanner;
import exchangeProgram.exchangeRate.DateFormat;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;

import java.util.Scanner;

public class ExchangeRatesTest {
    @Test()
    @Order(1)
    public void isValidDate() {
        boolean isValidDate = DateFormat.isValidDate("06.06.2022");
        Assertions.assertEquals(true, isValidDate, "Written date is incorrect");
    }

    @Test
    @Order(2)
    public void isInvalidDate() {
        boolean isInvalidDate = DateFormat.isValidDate("2022.06.06");
        Assertions.assertEquals(false, isInvalidDate, "Written date is correct");
    }

    @Test
    @Order(3)
    public void userCurrencyLetterCodeIsCorrectlyWritten() {
        CurrencyDateScanner currencyDateScanner = new CurrencyDateScanner();
        currencyDateScanner.scanUserCurrency();
        Assertions.assertEquals("AUD", currencyDateScanner.currencyLetterCode(), "Written code is incorrect");
    }

    @Test
    @Order(4)
    public void userCurrencyLetterCodeIsIncorrectlyWritten() {
        CurrencyDateScanner currencyDateScanner = new CurrencyDateScanner();
        currencyDateScanner.scanUserCurrency();
        Assertions.assertNotEquals(new Scanner(System.in).next(), currencyDateScanner.currencyLetterCode(), "Written code is correct");
    }
}
