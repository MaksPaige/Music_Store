package by.zhukovsky.musicstore.command;

import by.zhukovsky.musicstore.logic.DataLogic;
import by.zhukovsky.musicstore.logic.LoginLogic;
import by.zhukovsky.musicstore.logic.SessionLogic;
import by.zhukovsky.musicstore.resource.ConfigurationManager;

/**
 * Created by Maksim Zhukovsky on 24.03.2018.
 */

public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(RequestContent content) {
        String page = ConfigurationManager.getProperty("path.page.login");
        String login = content.getParameter(PARAM_NAME_LOGIN);
        String password = content.getParameter(PARAM_NAME_PASSWORD);
        if (LoginLogic.checkLogin(login, password)) {
            SessionLogic.saveUserDataInSession(login, content);
            if (LoginLogic.isAdmin(login)) {
                page = ConfigurationManager.getProperty("path.page.main_admin");
            } else {
                DataLogic.latestAlbumsData(content);
                if (LoginLogic.isUserAProvider(login)) {
                    page = ConfigurationManager.getProperty("path.page.user_provider_choice");
                } else {

                    page = ConfigurationManager.getProperty("path.page.main_user");
                }
            }
        }
        return page;
    }
}
