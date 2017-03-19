/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class Student {
    private int id;
    private String firstName;
    private String secondName;
    private double rating;
    private String lastContact;

    public String getLastContact() {
        return lastContact;
    }

    public void setLastContact(String lastContact) {
        this.lastContact = lastContact;
    }
    

    public Student() {
    }

    public Student(int id, String firstName, String secondName, double rating, String lastContact) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.rating = rating;
        this.lastContact = lastContact;
    }

    public Student(int id, String firstName, String secondName, double rating) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.rating = rating;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
}
