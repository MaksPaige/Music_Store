package by.zhukovsky.musicstore.validation;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Created by Maksim Zhukovsky on 27.03.2018.
 */

public class UserValidator {

    private static final String REGEX_EMAIL = "[\\p{Alpha}_\\-\\d]{5,60}@\\p{Alpha}{2,10}\\.(com|by|ru|gov|edu|org|net)";

    public static boolean isEmailCorrect(String email) {
        return (email.matches(REGEX_EMAIL));
    }

    public static boolean isDateOfBirthCorrect(int day, int month, int year) {
        boolean isDateValid = true;
        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            isDateValid = false;
        }
        return isDateValid;
    }

}
