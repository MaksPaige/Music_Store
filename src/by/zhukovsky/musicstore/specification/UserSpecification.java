package by.zhukovsky.musicstore.specification;

import by.zhukovsky.musicstore.entity.User;

/**
 * Created by Maksim Zhukovsky on 25.03.2018.
 */

public interface UserSpecification {

    boolean isSpecified(User user);

}
