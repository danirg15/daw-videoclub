package daw.upm.controllers;

import daw.upm.models.Movie;
import daw.upm.models.MovieRepository;
import daw.upm.services.JSONParser;
import daw.upm.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MoviesController {
    @Autowired
    private MovieRepository movieRepository;


    @RequestMapping (value = "/movies", method = RequestMethod.GET)
    public ModelAndView showMovies() {
        Iterable<Movie> movies = movieRepository.findAll();
        return new ModelAndView("/movies/movies").addObject("movies", movies);
    }

    @RequestMapping(value = "/movies/{id}/show", method = RequestMethod.GET)
    public ModelAndView showMovie(@PathVariable("id") long id) {
        Movie movie = this.movieRepository.findById(id);

        if(movie != null) {
            return new ModelAndView("/movies/movie").addObject("movie", movie);
        }

        return new ModelAndView("error");
    }

    @RequestMapping(value = "/movies/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editMovie(@PathVariable("id") long id) {
        Movie movie = this.movieRepository.findById(id);

        if(movie != null) {
            return new ModelAndView("/movies/edit-movie").addObject("movie", movie);
        }

        return new ModelAndView("error");
    }

    @RequestMapping(value = "/movies/{id}/update", method = RequestMethod.POST)
    public String updateMovie(@PathVariable("id") long id, @Valid Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/movies/edit-movie";
        }

        if(this.movieRepository.findById(id) == null) {
            return "error";
        }

        this.movieRepository.save(movie);

        return "redirect:/movies";
    }

    @RequestMapping(value = "/movies/create", method = RequestMethod.GET)
    public String createMovie(Movie movie) {
        return "movies/create-movie";
    }


    @RequestMapping(value = "/movies/store", method = RequestMethod.POST)
    public String storeMovie(@Valid Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/movies/create-movie";
        }

        this.movieRepository.save(movie);

        return "redirect:/movies";
    }


    @RequestMapping(value = "/movies/{id}/remove", method = RequestMethod.GET)
    public String removeMovie(@PathVariable("id") long id) {
        if(this.movieRepository.findById(id) == null) {
            return "error";
        }

        this.movieRepository.delete(id);

        return "redirect:/movies";
    }


    @RequestMapping(value = "/movies/{id}/display", method = RequestMethod.GET)
    public ModelAndView displayMovie(@PathVariable("id") long id) {
        Movie movie = this.movieRepository.findById(id);

        if(movie != null) {
            return new ModelAndView("/movies/display-movie").addObject("movie", movie);
        }

        return new ModelAndView("error");
    }

    @RequestMapping(value="/movies/search", method = RequestMethod.GET)
    public ModelAndView searchMovies(@PathParam("partialTitle") String partialTitle) {
        Iterable<Movie> movies = this.movieRepository.findByTitleContaining(partialTitle);
        return new ModelAndView("/movies/movie-list").addObject("movies", movies);
    }


    @RequestMapping(value="/movies/autocomplete", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String autocompleteMovie(@RequestParam("title") String title) {

        String json = MovieService.find(title);
        HashMap<String, Object> data = JSONParser.parseJson(json, null);
        ArrayList results = (ArrayList) data.get("results");

        HashMap<String, Object> a1 = (HashMap<String, Object>) results.get(0);

        return MovieService.getDetails((Integer) a1.get("id"));
    }
}