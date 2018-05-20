package by.zhukovsky.musicstore.entity;

import java.time.LocalDate;

public class Album extends Entity {

    private long performerId;
    private String name;
    private LocalDate releaseDate;
    private String imagePath;
    private double cost;
    private long genreId;

    public Album(long performerId, String name, LocalDate releaseDate, String imagePath, double cost, long genreId) {
        this.performerId = performerId;
        this.name = name;
        this.releaseDate = releaseDate;
        this.imagePath = imagePath;
        this.cost = cost;
        this.genreId = genreId;
    }

    public Album(long id, long performerId, String name, LocalDate releaseDate, String imagePath, double cost, long genreId) {
        super(id);
        this.performerId = performerId;
        this.name = name;
        this.releaseDate = releaseDate;
        this.imagePath = imagePath;
        this.cost = cost;
        this.genreId = genreId;
    }

    public long getPerformerId() {
        return performerId;
    }

    public void setPerformerId(long performerId) {
        this.performerId = performerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

}
