package by.zhukovsky.musicstore.repository;

import by.zhukovsky.musicstore.connection.ConnectionPool;
import by.zhukovsky.musicstore.connection.ProxyConnection;
import by.zhukovsky.musicstore.entity.Album;
import by.zhukovsky.musicstore.entity.Track;
import by.zhukovsky.musicstore.entity.User;
import by.zhukovsky.musicstore.specification.AlbumSpecification;
import by.zhukovsky.musicstore.specification.TrackSpecification;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrackRepository {

    private static final String ADD_TRACK = "INSERT INTO track(name, release_year, image_path, cost, album_id, genre_id, is_explicit) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_TRACK_BY_ID = "SELECT name, release_year, image_path, cost, album_id, genre_id, is_explicit FROM track WHERE track.id = ? LIMIT 1";
    private static final String UPDATE_TRACK = "UPDATE track SET name=?, release_year=?, image_path=?, cost=?, album_id=?, genre_id=?, is_explicit=? WHERE track.id = ?";
    private static final String GET_ALL_TRACKS = "SELECT id, name, release_year, image_path, cost, album_id, genre_id, is_explicit FROM track";

    public static void add(Track track) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(ADD_TRACK);
            statement.setString(1,track.getName());
            statement.setInt(2, track.getReleaseYear());
            statement.setString(3, track.getImagePath());
            statement.setDouble(4, track.getCost());
            statement.setLong(5, track.getAlbumId());
            statement.setLong(6, track.getGenreId());
            statement.setInt(7, track.isExplicit() ? 1 : 0);
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

    public static Track get(Long id) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        Track track = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(GET_TRACK_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                int releaseYear = resultSet.getInt(2);
                String imagePath = resultSet.getString(3);
                double cost = resultSet.getDouble(4);
                long albumId = resultSet.getLong(5);
                long genreId = resultSet.getLong(6);
                boolean isExplicit = resultSet.getInt(7) != 0;
                track = new Track(id, name, releaseYear, imagePath, cost, albumId, genreId, isExplicit);
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
        return track;
    }

    public static void update(Track track) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(UPDATE_TRACK);
            statement.setString(1, track.getName());
            statement.setInt(2, track.getReleaseYear());
            statement.setString(3, track.getImagePath());
            statement.setDouble(4, track.getCost());
            statement.setLong(5, track.getAlbumId());
            statement.setLong(6, track.getGenreId());
            statement.setInt(7, track.isExplicit() ? 1 : 0);
            statement.setLong(8, track.getId());
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

    public static List<Track> query(TrackSpecification specification) {
        ProxyConnection connection = null;
        PreparedStatement statement = null;
        List<Track> tracks = new ArrayList<>();
        try {
            connection = ConnectionPool.getInstance().defineConnection();
            statement = connection.prepareStatement(GET_ALL_TRACKS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                int releaseYear = resultSet.getInt(3);
                String imagePath = resultSet.getString(4);
                double cost = resultSet.getDouble(5);
                long albumId = resultSet.getLong(6);
                long genreId = resultSet.getLong(7);
                boolean isExplicit = resultSet.getInt(8) != 0;
                Track track = new Track(id, name, releaseYear, imagePath, cost, albumId, genreId, isExplicit);
                if (specification.isSpecified(track)) {
                    tracks.add(track);
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
        return tracks;
    }

}
