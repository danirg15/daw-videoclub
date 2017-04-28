package daw.upm.models;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private int year;
    private String date;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private String poster_url;
    private double rating;
    private String box_office;

    protected Movie() {

    }

    public Movie(String title,
                 int year,
                 String date,
                 String genre,
                 String director,
                 String actors,
                 String plot,
                 String poster_url,
                 double rating,
                 String box_office) {

        this.title = title;
        this.year = year;
        this.date = date;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.poster_url = poster_url;
        this.rating = rating;
        this.box_office = box_office;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getBox_office() {
        return box_office;
    }

    public void setBox_office(String box_office) {
        this.box_office = box_office;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", date='" + date + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", poster_url='" + poster_url + '\'' +
                ", rating=" + rating +
                ", box_office='" + box_office + '\'' +
                '}';
    }
}
