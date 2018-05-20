package by.zhukovsky.musicstore.command;

/**
 * Created by Maksim Zhukovsky on 20.03.2018.
 */

public class ActionFactory {

    public ActionCommand defineCommand(RequestContent content) {
        ActionCommand current = new EmptyCommand();
        String action = content.getParameter("command");
        CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
        current = currentEnum.getCurrentCommand();
        return current;
    }

}
