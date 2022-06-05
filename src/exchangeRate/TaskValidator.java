package exchangeRate;

public class TaskValidator {
    private final String[] params;

    public TaskValidator(String[] params) {
        this.params = params;
    }

    public boolean check() {
        if (moreThanThreeParams()) {
            System.out.println("Params can not be more than 3");
            return false;
        }
        for (int i = 1; i < params.length; i++) {
            if (notValidDate(params[i])) {
                System.out.println("Invalid parameter format entered. Correct Options: \n" +
                        "aud\n" +
                        "AUD\n" +
                        "AUD 2022.06.01\n" +
                        "AUD 31.05.2022 02.06.2022\n");
                return false;
            }
        }
        return true;
    }

    private boolean moreThanThreeParams() {
        return params.length > 3;
    }

    private boolean notValidDate(String dateStr) {
        return !DateFormat.isValidDate(dateStr);
    }
}