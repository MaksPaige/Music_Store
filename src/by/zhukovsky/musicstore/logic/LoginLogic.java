package by.zhukovsky.musicstore.logic;

import by.zhukovsky.musicstore.entity.User;
import by.zhukovsky.musicstore.repository.UserRepository;

/**
 * Created by Maksim Zhukovsky on 24.03.2018.
 */

public class LoginLogic {

    public static boolean checkLogin(String enterLogin, String enterPassword) {
        User user = UserRepository.get(enterLogin);
        return user != null && user.getPassword().equals(enterPassword);
    }

    public static boolean isAdmin(String enterLogin) {
        User user = UserRepository.get(enterLogin);
        return user.getRole().equals("admin");
    }

    public static boolean isUserAProvider(String enterLogin) {
        User user = UserRepository.get(enterLogin);
        return user.isProvider();
    }

}
