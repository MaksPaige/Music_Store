package by.zhukovsky.musicstore.repository;

import by.zhukovsky.musicstore.connection.ConnectionPool;
import by.zhukovsky.musicstore.connection.ProxyConnection;
import by.zhukovsky.musicstore.entity.User;
import by.zhukovsky.musicstore.specification.UserSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Maksim Zhukovsky on 25.03.2018.
 */

public class UserRepository {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String ADD_USER = "INSERT INTO user(login, password, dob, gender, first_name, second_name, email, role) VALUES (?, ?, ?, ?, ?, ?, ?, 'client')";
    private static final String GET_USER_BY_LOGIN = "SELECT id, password, dob, gender, cash, first_name, second_name, email, role, image_path, personal_discount, is_provider FROM user WHERE LOWER(user.login) = LOWER(?) LIMIT 1";
    private static final String UPDATE_USER = "UPDATE user SET password=?, dob=?, gender=?, cash=?, first_name=?, second_name=?, email=?, role=?, image_path=?, personal_discount=?, is_provider=? WHERE LOWER(user.login) = LOWER(?)";

    public static void add(User user) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(ADD_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setDate(3,  Date.valueOf(user.getDateOfBirth()));
            statement.setString(4, user.getGender());
            statement.setString(5, user.getFirstName());
            statement.setString(6, user.getSecondName());
            statement.setString(7, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static User get(String login) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        User user = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(GET_USER_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            LOGGER.debug(resultSet.toString());
            if (resultSet.next()) {
                long id = resultSet.getLong(1);
                String password = resultSet.getString(2);
                LocalDate dateOfBirth = resultSet.getDate(3).toLocalDate();
                String gender = resultSet.getString(4);
                double cash = resultSet.getDouble(5);
                String firstName = resultSet.getString(6);
                String secondName = resultSet.getString(7);
                String email = resultSet.getString(8);
                String role = resultSet.getString(9);
                String imagePath = resultSet.getString(10);
                double personalDiscount = resultSet.getDouble(11);
                boolean isProvider = resultSet.getInt(12) != 0;
                user = new User(id, login, password, dateOfBirth, gender, cash, firstName, secondName, email, role, imagePath, personalDiscount, isProvider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public static void update(User user) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1, user.getPassword());
            statement.setDate(2,  Date.valueOf(user.getDateOfBirth()));
            statement.setString(3, user.getGender());
            statement.setDouble(4, user.getCash());
            statement.setString(5, user.getFirstName());
            statement.setString(6, user.getSecondName());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getRole());
            statement.setString(9, user.getImagePath());
            statement.setDouble(10, user.getPersonalDiscount());
            statement.setInt(11, user.isProvider() ? 1 : 0);
            statement.setString(12, user.getLogin());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<User> query(UserSpecification specification) {
        return null;
    }

}
