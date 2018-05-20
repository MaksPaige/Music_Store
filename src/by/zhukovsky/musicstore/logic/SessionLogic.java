package by.zhukovsky.musicstore.logic;

import by.zhukovsky.musicstore.command.RequestContent;
import by.zhukovsky.musicstore.entity.User;
import by.zhukovsky.musicstore.repository.UserRepository;

public class SessionLogic {

    private static final String USER_ID_ATTRIBUTE = "user-id";
    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String EMAIL_ATTRIBUTE = "email";
    private static final String ROLE_ATTRIBUTE = "role";
    private static final String AVATAR_ATTRIBUTE = "avatar";
    private static final String USER_NAME_ATTRIBUTE = "firstName";
    private static final String USER_CASH_ATTRIBUTE = "cash";

    public static void saveUserDataInSession(String login, RequestContent content) {
        User user = UserRepository.get(login);
        content.setSessionAttribute(USER_ID_ATTRIBUTE, user.getId());
        content.setSessionAttribute(LOGIN_ATTRIBUTE, user.getLogin());
        content.setSessionAttribute(EMAIL_ATTRIBUTE, user.getEmail());
        content.setSessionAttribute(ROLE_ATTRIBUTE, user.getRole());
        content.setSessionAttribute(AVATAR_ATTRIBUTE, user.getImagePath());
        content.setSessionAttribute(USER_NAME_ATTRIBUTE, user.getFirstName());
        content.setSessionAttribute(USER_CASH_ATTRIBUTE, user.getCash());
    }

}
