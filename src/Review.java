/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class Review {
    private int stID;
    private int subID;
    private String firstName;
    private String secondName;
    private double Rating;
    private String lastCont;

    public Review(int stID, int subID, String firstName, String secondName, double Rating, String lastCont) {
        this.stID = stID;
        this.subID = subID;
        this.firstName = firstName;
        this.secondName = secondName;
        this.Rating = Rating;
        this.lastCont = lastCont;
    }

    public Review() {
    }

    public int getStID() {
        return stID;
    }

    public void setStID(int stID) {
        this.stID = stID;
    }

    public int getSubID() {
        return subID;
    }

    public void setSubID(int subID) {
        this.subID = subID;
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
        return Rating;
    }

    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    public String getLastCont() {
        return lastCont;
    }

    public void setLastCont(String lastCont) {
        this.lastCont = lastCont;
    }
    
}
