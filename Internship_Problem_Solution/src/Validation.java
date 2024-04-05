import java.util.List;

public class Validation {
    public boolean validateName(String name) {
        List<String> list = List.of(name.split(" "));

        if (list.size() < 2)
            return false;

        return true;
    }

    public boolean validateEmail(String email) {

        if (email == null || email.isEmpty()) {
            return false;
        }

        if (!Character.isLetter(email.charAt(0))) {
            return false;
        }

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (c < 32 || c > 126) {
                return false;
            }
        }

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '@' && c != '.' && c != '_' && c != '-') {
                return false;
            }
        }

        int countAt = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                countAt++;
            }
        }
        if (countAt != 1) {
            return false;
        }

        int indexOfAt = email.indexOf('@');
        int indexOfDotAfterAt = email.indexOf('.', indexOfAt);
        if (indexOfDotAfterAt == -1 || indexOfDotAfterAt == indexOfAt + 1 || indexOfDotAfterAt == email.length() - 1) {
            return false;
        }

        if (!Character.isLetter(email.charAt(email.length() - 1))) {
            return false;
        }

        return true;
    }

    public boolean validateDateTime(String dateTime) {
        if (dateTime == null || dateTime.isEmpty()) {
            return false;
        }

        if (!dateTime.matches("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$")) {
            return false;
        }

        String[] parts = dateTime.split("T");
        String datePart = parts[0];
        String timePart = parts[1];

        String[] dateParts = datePart.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        String[] timeParts = timePart.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);

        if (year < 1000 || year > 9999 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        if (hour < 0 || hour > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
            return false;
        }

        return true;
    }

    public boolean validateScore(String score) {
        if (score == null || score.isEmpty()) {
            return false;
        }

        if (!score.matches("^\\d+(\\.\\d{1,2})?$")) {
            return false;
        }

        String[] parts = score.split("\\.");
        int integerPart = Integer.parseInt(parts[0]);
        int decimalPart = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;

        if (integerPart < 0 || integerPart > 10) {
            return false;
        }

        if (decimalPart < 0 || decimalPart > 99) {
            return false;
        }

        return true;
    }
}
