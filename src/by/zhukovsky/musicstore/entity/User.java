package by.zhukovsky.musicstore.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Maksim Zhukovsky on 25.03.2018.
 */

public class User extends Entity {

    private String login;
    private String password;
    private LocalDate dateOfBirth;
    private String gender;
    private double cash;
    private String firstName;
    private String secondName;
    private String email;
    private String role;
    private String imagePath;
    private double personalDiscount;
    private boolean isProvider;

    public User(String login, String password, LocalDate dateOfBirth, String gender, String firstName, String secondName, String email, String role) {
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.role = role;
    }

    public User(String login, String password, LocalDate dateOfBirth, String gender, double cash, String firstName, String secondName, String email, String role, String imagePath, double personalDiscount, boolean isProvider) {
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cash = cash;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.role = role;
        this.imagePath = imagePath;
        this.personalDiscount = personalDiscount;
        this.isProvider = isProvider;
    }

    public User(long id, String login, String password, LocalDate dateOfBirth, String gender, double cash, String firstName, String secondName, String email, String role, String imagePath, double personalDiscount, boolean isProvider) {
        super(id);
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cash = cash;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.role = role;
        this.imagePath = imagePath;
        this.personalDiscount = personalDiscount;
        this.isProvider = isProvider;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(double personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isProvider() {
        return isProvider;
    }

    public void setProvider(boolean isProvider) {
        this.isProvider = isProvider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Double.compare(user.cash, cash) == 0 &&
                Double.compare(user.personalDiscount, personalDiscount) == 0 &&
                isProvider == user.isProvider &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(role, user.role) &&
                Objects.equals(imagePath, user.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, dateOfBirth, gender, cash, firstName, secondName, email, role, imagePath, personalDiscount, isProvider);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", cash=" + cash +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", personalDiscount=" + personalDiscount +
                ", isProvider=" + isProvider +
                '}';
    }

}
