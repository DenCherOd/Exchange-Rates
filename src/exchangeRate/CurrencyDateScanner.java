package exchangeRate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CurrencyDateScanner {
    private Scanner scanner;
    private String currencyLetterCode;
    private String dateFrom;
    private String dateTo;
    private ArrayList<String> days = new ArrayList<>();

    public ArrayList<String> getDays() {
        return days;
    }

    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void scanUserCurrency() {
        scanner = new Scanner(System.in);
        System.out.println("Enter the name of the currency you are interested in.\n" +
                "If you are interested in a specific date, please enter it.\n" +
                "For example: \nAUD\nor \nAUD 01.06.2022-03.06.2022");
        boolean continueSearching = true;
        while (continueSearching) {
            String result = scanner.nextLine();
            if (result.matches("[A-Z]{3} \\d{2}\\.\\d{2}\\.\\d{4}-\\d{2}\\.\\d{2}\\.\\d{4}")
                    || result.matches("[A-Z]{3}")) {
                String[] userCurrencyArray = result.split("( |-)");
                currencyLetterCode = userCurrencyArray[0];
                if (userCurrencyArray.length > 1) {
                    dateFrom = userCurrencyArray[1];
                    dateTo = userCurrencyArray[2];
                    getAllDays();
                    continueSearching = false;
                } else {
                    System.out.println("You entered wrong data. Try again");
                    System.out.println("Enter the name of the currency you are interested in.\n" +
                            "If you are interested in a specific date, please enter it.\n" +
                            "For example: \nAUD\nor \nAUD 01.06.2022-03.06.2022");
                }
            }
        }
    }

    public String currencyLetterCode() {
        return currencyLetterCode;
    }

    private void getAllDays() {
        String[] fromDateArray = dateFrom.split("\\.");
        String[] toDateArray = dateTo.split("\\.");
        LocalDate dateFrom = LocalDate.of(Integer.valueOf(fromDateArray[2]), Integer.valueOf(fromDateArray[1]), Integer.valueOf(fromDateArray[0]));
        LocalDate dateTo = LocalDate.of(Integer.valueOf(toDateArray[2]), Integer.valueOf(toDateArray[1]), Integer.valueOf(toDateArray[0]));
        List<LocalDate> allDays = getDatesBetweenUsing(dateFrom, dateTo);
        for (LocalDate day : allDays) {
            days.add(day.format(DATE_FORMATTER));
        }
    }

    public static List<LocalDate> getDatesBetweenUsing(
            LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween + 1)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }
}