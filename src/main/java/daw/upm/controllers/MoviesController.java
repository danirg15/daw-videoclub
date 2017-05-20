package daw.upm.controllers;

import daw.upm.models.Movie;
import daw.upm.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MoviesController {
    @Autowired
    private MovieRepository movieRepository;


    @RequestMapping (value = "/movies", method = RequestMethod.GET)
    public ModelAndView showMovies() {
        Iterable<Movie> movies = movieRepository.findAll();
        return new ModelAndView("movies").addObject("movies", movies);
    }

    @RequestMapping(value = "/movies/{id}/show", method = RequestMethod.GET)
    public ModelAndView showMovie(@PathVariable("id") long id) {
        Movie movie = this.movieRepository.findById(id);

        if(movie != null) {
            return new ModelAndView("movie").addObject("movie", movie);
        }

        return new ModelAndView("error");
    }

    @RequestMapping(value = "/movies/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editMovie(@PathVariable("id") long id) {

        Movie movie = this.movieRepository.findById(id);

        if(movie != null) {

        }

        //TODO: Formulario para editar pelicula
        return null;
    }

    @RequestMapping(value = "/movies/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateMovie(@PathVariable("id") long id, @ModelAttribute Movie movie) {

        //TODO: Actualizar pelicula

        System.out.println(movie.toString());

        return null;
    }

    @RequestMapping(value = "/movies/create", method = RequestMethod.GET)
    public String createMovie(Movie movie) {
        return "movie-form";
    }


    @RequestMapping(value = "/movies/store", method = RequestMethod.POST)
    public String storeMovie(@Valid Movie movie, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "movie-form";
        }

        this.movieRepository.save(movie);

        return "redirect:/movies";
    }


    @RequestMapping(value = "/movies/{id}/remove", method = RequestMethod.POST)
    public ModelAndView removeMovie(@PathVariable("id") long id) {
        //TODO: Eliminar pelicula
        return null;
    }



}