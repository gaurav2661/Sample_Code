package Thrillio.Entities;

import java.util.Arrays;

public  class Book extends Bookmark{
    private int publication_Year;
    private String publisher;
    private String[] authors;
    private String genre;
    private double amazon_Ratings;

    // creating getters and setter for these private fields


    public int getPublication_Year() {
        return publication_Year;
    }

    public void setPublication_Year(int publication_Year) {
        this.publication_Year = publication_Year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmazon_Ratings() {
        return amazon_Ratings;
    }

    public void setAmazon_Ratings(double amazon_Ratings) {
        this.amazon_Ratings = amazon_Ratings;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publication_Year=" + publication_Year +
                ", publisher='" + publisher + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", genre='" + genre + '\'' +
                ", amazon_Ratings=" + amazon_Ratings +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
        return false;
    }
}
