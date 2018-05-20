package by.zhukovsky.musicstore.repository;

import by.zhukovsky.musicstore.connection.ConnectionPool;
import by.zhukovsky.musicstore.connection.ProxyConnection;
import by.zhukovsky.musicstore.entity.Performer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PerformerRepository {

    private static final String ADD_PERFORMER = "INSERT INTO performer(name, description, user_id, email) VALUES (?, ?, ?, ?)";
    private static final String GET_USER_BY_LOGIN = "SELECT password, dob, gender, cash, first_name, second_name, email, role, image_path, personal_discount, is_provider FROM user WHERE LOWER(user.login) = LOWER(?) LIMIT 1";


    public static void add(Performer performer) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(ADD_PERFORMER);
            statement.setString(1, performer.getName());
            statement.setString(2, performer.getDescription());
            statement.setLong(3, performer.getUserId());
            statement.setString(4, performer.getEmail());
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



}
