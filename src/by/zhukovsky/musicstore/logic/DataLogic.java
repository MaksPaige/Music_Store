package by.zhukovsky.musicstore.logic;

import by.zhukovsky.musicstore.command.RequestContent;
import by.zhukovsky.musicstore.entity.Album;
import by.zhukovsky.musicstore.entity.Track;
import by.zhukovsky.musicstore.repository.AlbumRepository;
import by.zhukovsky.musicstore.repository.TrackRepository;
import by.zhukovsky.musicstore.specification.impl.AlbumTrackSpecification;

import java.util.List;

public class DataLogic {

    public static void latestAlbumsData(RequestContent content) {
        List<Album> latestReleases = AlbumRepository.getLatestReleases();
        content.setSessionAttribute("latestAlbums", latestReleases);
    }

    public static void albumData(long albumId, RequestContent content) {
        Album album = AlbumRepository.get(albumId);
        List<Track> tracks = TrackRepository.query(new AlbumTrackSpecification(albumId));
        content.setAttribute("album", album);
        content.setAttribute("trackCount", tracks.size());
        content.setAttribute("trackList", tracks);
    }

}
