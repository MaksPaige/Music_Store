package by.zhukovsky.musicstore.entity;

public class Track extends Entity {

    private String name;
    private int releaseYear;
    private String imagePath;
    private double cost;
    private long albumId;
    private long genreId;
    private boolean isExplicit;

    public Track(String name, int releaseYear, String imagePath, double cost, long albumId, long genreId, boolean isExplicit) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.imagePath = imagePath;
        this.cost = cost;
        this.albumId = albumId;
        this.genreId = genreId;
        this.isExplicit = isExplicit;
    }

    public Track(long id, String name, int releaseYear, String imagePath, double cost, long albumId, long genreId, boolean isExplicit) {
        super(id);
        this.name = name;
        this.releaseYear = releaseYear;
        this.imagePath = imagePath;
        this.cost = cost;
        this.albumId = albumId;
        this.genreId = genreId;
        this.isExplicit = isExplicit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
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

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public boolean isExplicit() {
        return isExplicit;
    }

    public void setExplicit(boolean explicit) {
        isExplicit = explicit;
    }
}
