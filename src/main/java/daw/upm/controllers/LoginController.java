package daw.upm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping ("/login")
    public ModelAndView showLogin() {
        return new ModelAndView( "login" );
    }
}