package by.zhukovsky.musicstore.entity;

public class Performer extends Entity {

    private String name;
    private String description;
    private String imagePath;
    private boolean isVerified;
    private long userId;
    private String email;

    public Performer(String name, String description, long userId, String email) {
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.email = email;
    }

    public Performer(String name, String description, String imagePath, boolean isVerified, long userId, String email) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.isVerified = isVerified;
        this.userId = userId;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
