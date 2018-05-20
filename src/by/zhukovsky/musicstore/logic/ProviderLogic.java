package by.zhukovsky.musicstore.logic;

import by.zhukovsky.musicstore.entity.User;
import by.zhukovsky.musicstore.repository.UserRepository;

public class ProviderLogic {

    public static boolean isAvailableProvide(String login) {
        User user = UserRepository.get(login);
        return !user.isProvider();
    }

    public static void makeUserAProvider(String login) {
        User user = UserRepository.get(login);
        user.setProvider(true);
        UserRepository.update(user);
    }

}
