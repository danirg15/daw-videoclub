package daw.upm.controllers;

import daw.upm.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import daw.upm.models.User;
import daw.upm.models.UserRepository;

import javax.validation.Valid;

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


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        Iterable<User> users = userRepository.findAll();
        return new ModelAndView("users/users").addObject("users", users);
    }



    @RequestMapping(value = "/users/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") long id) {
        User user = this.userRepository.findById(id);

        if(user != null) {
            return new ModelAndView("users/edit-user").addObject("user", user);
        }

        return new ModelAndView("error");
    }

    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult bindingResult) {
        //TODO
        return null;
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public String createUser(User user) {
        return "users/create-user";
    }


    @RequestMapping(value = "/users/store", method = RequestMethod.POST)
    public String storeUser(@Valid User user, BindingResult bindingResult) {
        //TODO
        return null;
    }


    @RequestMapping(value = "/users/{id}/remove", method = RequestMethod.POST)
    public String removeUser(@PathVariable("id") long id) {
        if(this.userRepository.findById(id) == null) {
            return "error";
        }

        this.userRepository.delete(id);

        return "redirect:users/users";
    }

}