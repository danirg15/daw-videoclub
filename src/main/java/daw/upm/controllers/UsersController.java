package daw.upm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import daw.upm.models.User;
import daw.upm.models.UserRepository;

@Controller
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping ("/user/{id}")
    @ResponseBody
    public String getUser(@PathVariable("id") long id) {
        User user = null;
        try {
            user = userRepository.findById(1);
            System.out.println(user.toString());
        }
        catch (Exception ex) {
            return "Usuario no econtrado";
        }
        return user.toString();
    }


    @RequestMapping ("/users")
    @ResponseBody
    public String getUsers() {
        Iterable<User> users = null;
        try {
            users = userRepository.findAll();
            System.out.println(users.toString());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return users.toString();
    }

}