package by.zhukovsky.musicstore.command;

import by.zhukovsky.musicstore.entity.User;
import by.zhukovsky.musicstore.logic.SignupLogic;
import by.zhukovsky.musicstore.repository.UserRepository;
import by.zhukovsky.musicstore.resource.ConfigurationManager;

import java.time.LocalDate;

/**
 * Created by Maksim Zhukovsky on 26.03.2018.
 */

public class SignupCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_GENDER = "gender";
    private static final String PARAM_NAME_FIRST_NAME = "first-name";
    private static final String PARAM_NAME_SECOND_NAME = "second-name";
    private static final String PARAM_NAME_DAY_OF_BIRTH = "day-of-birth";
    private static final String PARAM_NAME_MONTH_OF_BIRTH = "month-of-birth";
    private static final String PARAM_NAME_YEAR_OF_BIRTH = "year-of-birth";

    @Override
    public String execute(RequestContent content) {
        String page = ConfigurationManager.getProperty("path.page.signup");
        String login = content.getParameter(PARAM_NAME_LOGIN);
        String password = content.getParameter(PARAM_NAME_PASSWORD);
        String email = content.getParameter(PARAM_NAME_EMAIL);
        String gender = content.getParameter(PARAM_NAME_GENDER);
        String firstName = content.getParameter(PARAM_NAME_FIRST_NAME);
        String secondName = content.getParameter(PARAM_NAME_SECOND_NAME);
        int dayOfBirth = Integer.parseInt(content.getParameter(PARAM_NAME_DAY_OF_BIRTH));
        int monthOfBirth = Integer.parseInt(content.getParameter(PARAM_NAME_MONTH_OF_BIRTH));
        int yearOfBirth = Integer.parseInt(content.getParameter(PARAM_NAME_YEAR_OF_BIRTH));
        if (SignupLogic.checkNewUser(login, password, email, gender, firstName, secondName, dayOfBirth, monthOfBirth, yearOfBirth)) {
            UserRepository.add(new User(login, password, LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth), gender, firstName, secondName, email, "client"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
