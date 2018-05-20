package by.zhukovsky.musicstore.repository;

import by.zhukovsky.musicstore.connection.ConnectionPool;
import by.zhukovsky.musicstore.connection.ProxyConnection;
import by.zhukovsky.musicstore.entity.Album;
import by.zhukovsky.musicstore.entity.User;
import by.zhukovsky.musicstore.specification.AlbumSpecification;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {

    private static final String ADD_ALBUM = "INSERT INTO album(performer_id, name, release_date, image_path, cost, genre_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ALBUM_BY_ID = "SELECT performer_id, name, release_date, image_path, cost, genre_id FROM album WHERE album.id = ? LIMIT 1";
    private static final String UPDATE_ALBUM = "UPDATE album SET performer_id=?, name=?, release_date=?, image_path=?, cost=?, genre_id=? WHERE album.id = ?";
    private static final String GET_ALL_ALBUMS = "SELECT id, performer_id, name, release_date, image_path, cost, genre_id FROM album";
    private static final String GET_LATEST_ALBUMS = "SELECT id, performer_id, name, release_date, image_path, cost, genre_id FROM album ORDER BY release_date DESC LIMIT 4";

    public static void add(Album album) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(ADD_ALBUM);
            statement.setLong(1, album.getPerformerId());
            statement.setString(2, album.getName());
            statement.setDate(3, Date.valueOf(album.getReleaseDate()));
            statement.setString(4, album.getImagePath());
            statement.setDouble(5, album.getCost());
            statement.setLong(6, album.getGenreId());
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

    public static Album get(Long id) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        Album album = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(GET_ALBUM_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long performerId = resultSet.getLong(1);
                String name = resultSet.getString(2);
                LocalDate releaseDate = resultSet.getDate(3).toLocalDate();
                String imagePath = resultSet.getString(4);
                double cost = resultSet.getDouble(5);
                long genreId = resultSet.getLong(6);
                album = new Album(id, performerId, name, releaseDate, imagePath, cost, genreId);
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
        return album;
    }

    public static void update(Album album) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(UPDATE_ALBUM);
            statement.setLong(1, album.getPerformerId());
            statement.setString(2, album.getName());
            statement.setDate(3, Date.valueOf(album.getReleaseDate()));
            statement.setString(4, album.getImagePath());
            statement.setDouble(5, album.getCost());
            statement.setLong(6, album.getGenreId());
            statement.setLong(7, album.getId());
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

    public static List<Album> getLatestReleases() {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        List<Album> latestAlbums = new ArrayList<>();
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(GET_LATEST_ALBUMS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                long performerId = resultSet.getLong(2);
                String name = resultSet.getString(3);
                LocalDate releaseDate = resultSet.getDate(4).toLocalDate();
                String imagePath = resultSet.getString(5);
                double cost = resultSet.getDouble(6);
                long genreId = resultSet.getLong(7);
                latestAlbums.add(new Album(id, performerId, name, releaseDate, imagePath, cost, genreId));
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
        return latestAlbums;
    }

    public static List<Album> query(AlbumSpecification specification) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        List<Album> albums = new ArrayList<>();
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(GET_ALL_ALBUMS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                long performerId = resultSet.getLong(2);
                String name = resultSet.getString(3);
                LocalDate releaseDate = resultSet.getDate(4).toLocalDate();
                String imagePath = resultSet.getString(5);
                double cost = resultSet.getDouble(6);
                long genreId = resultSet.getLong(7);
                Album album = new Album(id, performerId, name, releaseDate, imagePath, cost, genreId);
                if (specification.isSpecified(album)) {
                    albums.add(album);
                }
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
        return albums;
    }

}
