package by.zhukovsky.musicstore.specification.impl;

import by.zhukovsky.musicstore.entity.Track;
import by.zhukovsky.musicstore.specification.TrackSpecification;

public class AlbumTrackSpecification implements TrackSpecification {

    private long albumId;

    public AlbumTrackSpecification(long albumId) {
        this.albumId = albumId;
    }

    @Override
    public boolean isSpecified(Track track) {
        return track.getAlbumId() == albumId;
    }

}
