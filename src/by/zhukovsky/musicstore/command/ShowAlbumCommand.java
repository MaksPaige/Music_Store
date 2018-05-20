package by.zhukovsky.musicstore.command;

import by.zhukovsky.musicstore.logic.DataLogic;
import by.zhukovsky.musicstore.resource.ConfigurationManager;

public class ShowAlbumCommand implements ActionCommand {

    private final static String PARAM_ALBUM_ID = "album-id";

    @Override
    public String execute(RequestContent content) {
        String page = ConfigurationManager.getProperty("path.page.album");
        long albumId = Long.parseLong(content.getParameter(PARAM_ALBUM_ID));
        DataLogic.albumData(albumId, content);
        return page;
    }

}
