package by.zhukovsky.musicstore.command;

import by.zhukovsky.musicstore.entity.Performer;
import by.zhukovsky.musicstore.entity.User;
import by.zhukovsky.musicstore.logic.ProviderLogic;
import by.zhukovsky.musicstore.logic.SignupLogic;
import by.zhukovsky.musicstore.repository.PerformerRepository;
import by.zhukovsky.musicstore.repository.UserRepository;
import by.zhukovsky.musicstore.resource.ConfigurationManager;

import java.security.Provider;
import java.time.LocalDate;

public class BecomeProviderCommand implements ActionCommand {

    private static final String PARAM_NAME_ARTIST = "artist-name";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_DESCRIPTION = "description";
    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String USER_ID_ATTRIBUTE = "user-id";

    @Override
    public String execute(RequestContent content) {
        String page = ConfigurationManager.getProperty("path.page.become_provider");
        String artistName = content.getParameter(PARAM_NAME_ARTIST);
        String email = content.getParameter(PARAM_NAME_EMAIL);
        String description = content.getParameter(PARAM_NAME_DESCRIPTION);
        String login = (String) content.getSessionAttribute(LOGIN_ATTRIBUTE);
        long userId = (long) content.getSessionAttribute(USER_ID_ATTRIBUTE);
        if (ProviderLogic.isAvailableProvide(login)) {
            PerformerRepository.add(new Performer(artistName, description, userId, email));
            ProviderLogic.makeUserAProvider(login);
            page = ConfigurationManager.getProperty("path.page.user_provider_choice");
        }
        /*if (SignupLogic.checkNewUser(login, password, email, gender, firstName, secondName, dayOfBirth, monthOfBirth, yearOfBirth)) {
            UserRepository.add(new User(login, password, LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth), gender, firstName, secondName, email, "client"));
            page = ConfigurationManager.getProperty("path.page.login");
        } */
        return page;
    }

}
