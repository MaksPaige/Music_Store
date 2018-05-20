package by.zhukovsky.musicstore.command;

import by.zhukovsky.musicstore.resource.ConfigurationManager;

/**
 * Created by Maksim Zhukovsky on 24.03.2018.
 */

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(RequestContent content) {
        return ConfigurationManager.getProperty("path.page.index");
    }

}
