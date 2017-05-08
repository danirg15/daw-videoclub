package daw.upm.controllers;

import daw.upm.models.Movie;
import daw.upm.models.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoviesController {
    @Autowired
    MovieRepository movieRepository;


    @RequestMapping (value = "/movies", method = RequestMethod.GET)
    public ModelAndView showMovies() {
        //TODO: Mostrar todas las peliculas

        System.out.print(movieRepository.findAll().toString());

        return null;
    }

    @RequestMapping(value = "/movies/{id}/show", method = RequestMethod.GET)
    public ModelAndView showMovie(@PathVariable("id") long id) {
        //TODO: Mostrar una pelicula
        return null;
    }

    @RequestMapping(value = "/movies/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editMovie(@PathVariable("id") long id) {
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
    public ModelAndView createMovie() {
        //TODO: Formulario para crear pelicula
        return null;
    }


    @RequestMapping(value = "/movies/store", method = RequestMethod.POST)
    public ModelAndView storeMovie(@ModelAttribute Movie movie) {

        //TODO: Crear pelicula

        System.out.println(movie.toString());


        return null;
    }


    @RequestMapping(value = "/movies/{id}/remove", method = RequestMethod.POST)
    public ModelAndView removeMovie(@PathVariable("id") long id) {
        //TODO: Eliminar pelicula
        return null;
    }



}