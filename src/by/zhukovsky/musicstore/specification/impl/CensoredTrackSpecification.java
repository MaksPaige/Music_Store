package by.zhukovsky.musicstore.specification.impl;

import by.zhukovsky.musicstore.entity.Track;
import by.zhukovsky.musicstore.specification.TrackSpecification;

public class CensoredTrackSpecification implements TrackSpecification {

    @Override
    public boolean isSpecified(Track track) {
        return !track.isExplicit();
    }

}
