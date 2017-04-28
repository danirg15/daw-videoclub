package daw.upm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import daw.upm.models.Movie;
import daw.upm.models.MovieRepository;

@Controller
public class MoviesController {
    @Autowired
    private MovieRepository movieRepository;





}