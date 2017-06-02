package daw.upm.controllers;


import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ModelAndView error() {
        return new ModelAndView( "error" );
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}