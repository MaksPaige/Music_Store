package by.zhukovsky.musicstore.specification;

import by.zhukovsky.musicstore.entity.Track;

public interface TrackSpecification {

    boolean isSpecified(Track track);

}
