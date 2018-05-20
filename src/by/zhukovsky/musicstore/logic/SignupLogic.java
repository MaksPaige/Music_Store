package by.zhukovsky.musicstore.logic;

import by.zhukovsky.musicstore.repository.UserRepository;
import by.zhukovsky.musicstore.validation.UserValidator;

/**
 * Created by Maksim Zhukovsky on 26.03.2018.
 */

public class SignupLogic {

    public static boolean checkNewUser(String login, String password, String email, String gender, String firstName, String secondName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        return
                //UserRepository.isLoginFree(login) &&
                        UserValidator.isEmailCorrect(email) && UserValidator.isDateOfBirthCorrect(dayOfBirth, monthOfBirth, yearOfBirth);
    }

}
