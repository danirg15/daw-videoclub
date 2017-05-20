package daw.upm.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.annotations.Message;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @Min(1900)
    private int year;

    @NotNull
    @NotEmpty
    private String genre;

    @NotNull
    @NotEmpty
    private String director;

    @NotNull
    @NotEmpty
    private String actors;

    @NotNull
    @NotEmpty
    private String plot;

    private String date;

    @NotNull
    @NotEmpty
    private String poster_url;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(0)
    @Max(5)
    private double rating;

    private double box_office;

    public Movie() {

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
                 double box_office) {

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

    public double getBox_office() {
        return box_office;
    }

    public void setBox_office(double box_office) {
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
