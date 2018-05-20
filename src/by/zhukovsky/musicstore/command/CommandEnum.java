package by.zhukovsky.musicstore.command;

/**
 * Created by Maksim Zhukovsky on 24.03.2018.
 */

public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    SIGNUP {
        {
            this.command = new SignupCommand();
        }
    },
    BECOMEPROVIDER {
        {
            this.command = new BecomeProviderCommand();
        }
    },
    SHOWALBUM {
        {
            this.command = new ShowAlbumCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}
