package model;

import javax.persistence.*;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String passportNumberSeries;

    public User() {

    }

    public User(int id, String firstName, String lastName, String passportNumberSeries) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumberSeries = passportNumberSeries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNumberSeries() {
        return passportNumberSeries;
    }

    public void setPassportNumberSeries(String passportNumberSeries) {
        this.passportNumberSeries = passportNumberSeries;
    }
}
