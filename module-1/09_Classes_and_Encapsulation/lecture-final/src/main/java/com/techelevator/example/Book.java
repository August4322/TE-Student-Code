package com.techelevator.example;

public class Book {

    //properties (STATE)
    private String title = "";
    private String callNumber; // "FIC 123"
    public String author = "Stephen King";
    private String genre;
    private int pageCount;
    private int edition;
    private int yearPublished;
    private boolean paperback;
    private double cost = 12.99;

    // Constructor
    // No return type
    // The name will always match the classname exactly
    // used for initializing the object

    public Book(){
        paperback= true; // we can define default values
        callNumber = "";
    }

    // When we have the same constructor or method name but a different number of parameters, that is called overloading
    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String callNumber, String author, boolean paperback, String genre, int pageCount, int edition, int yearPublished) {
        this.title = title;
        this.callNumber = callNumber;
        this.author = author;
        this.paperback = paperback;
        this.genre = genre;
        this.pageCount = pageCount;
        this.edition = edition;
        this.yearPublished = yearPublished;
    }

    // Getters - return a property to an outside caller
    // If we want a property to be read only, then we only create a getter, no setter
    public String getTitle() {
        return title;
    }

    // Setter - receive a value from an outside caller, and update the internal property
    public void setTitle(String title) {
        // this.title refers to the property
        // title on its own refers to the parameter being passed in
        this.title = title;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author){
        this.author += ", " + author;
    }

    public boolean isPaperback() {
        return paperback;
    }

    public void setPaperback(boolean paperback) {
        this.paperback = paperback;
    }

    // As a getter, I can define a derived property
    public String getFullDisplayName() {
        return title + " - " + author + " - " + genre;
    }

    // BEHAVIOR

    public double calculateSalePrice(double discountPercent) {
        return cost * (1-(discountPercent/100));
    }
}
