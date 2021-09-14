package Thrillio.Entities;

import java.util.Arrays;

public class Movie extends Bookmark{
    private int release_Year;
    private String[] cast;
    private String[] directors;
    private String genre;
    private double imdb_Ratings;


    // creating getters and setter for these private fields


    public void setReleaseYear(int RELEASE_YEAR){
        this.release_Year=RELEASE_YEAR;
    }
    public void setCast(String[] CAST){
        this.cast=CAST;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "release_Year=" + release_Year +
                ", cast=" + Arrays.toString(cast) +
                ", directors=" + Arrays.toString(directors) +
                ", genre='" + genre + '\'' +
                ", imdb_Ratings=" + imdb_Ratings +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
        return false;
    }

    public void setDirectors(String[] DIRECTORS){
        this.directors=DIRECTORS;
    }
    public void setGenre(String GENRE){
        this.genre=GENRE;
    }
    public void setImdb_Ratings(double IMDB_RATINGS){
        this.imdb_Ratings =IMDB_RATINGS;
    }
    public int getReleaseYear(){
        return release_Year;
    }
    public String[] getDirectors(){
        return directors;
    }
    public String[] getCast(){
        return cast;
    }
    public String getGenre(){
        return genre;
    }
    public double getImdb_Ratings(){
        return imdb_Ratings;
    }

}
