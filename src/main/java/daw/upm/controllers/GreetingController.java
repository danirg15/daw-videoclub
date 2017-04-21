package daw.upm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @RequestMapping ("/list" )
    public ModelAndView greeting() {
        return new ModelAndView( "lista" ).addObject( "name", "World");
    }

}