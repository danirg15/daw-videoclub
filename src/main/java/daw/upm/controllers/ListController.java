package daw.upm.controllers;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {
    @Secured({"ROLE_USER"})
    @RequestMapping ("/list")
    public ModelAndView showList() {
        return new ModelAndView( "lista" ).addObject("name", "World");
    }
}