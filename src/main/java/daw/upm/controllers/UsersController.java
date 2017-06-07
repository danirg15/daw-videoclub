package daw.upm.controllers;

import daw.upm.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import daw.upm.models.User;
import daw.upm.models.UserRepository;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @Secured({"ROLE_USER"})
    @RequestMapping ("/users/{id}")
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

    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        Iterable<User> users = userRepository.findAll();
        return new ModelAndView("users/users").addObject("users", users);
    }


    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/users/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") long id) {
        User user = this.userRepository.findById(id);

        if(user != null) {
            return new ModelAndView("users/edit-user").addObject("user", user);
        }

        return new ModelAndView("error");
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/users/{id}/edit", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") long id, @Valid User updatedUser, BindingResult bindingResult) {
        User user = this.userRepository.findById(id);
        if(user == null) {
            return "redirect:/users";
        }

        if(updatedUser.getEmail() != "" && !updatedUser.getEmail().equals(user.getEmail())) {
            user.setEmail(updatedUser.getEmail());
        }

        if(updatedUser.getFirstName() != "" && !updatedUser.getFirstName().equals(user.getFirstName())) {
            user.setFirstName(updatedUser.getFirstName());
        }

        if(updatedUser.getLastName() != "" && !updatedUser.getLastName().equals(user.getLastName())) {
            user.setLastName(updatedUser.getLastName());
        }

        if(updatedUser.getPasswordHash() != "") {
            user.setPasswordHash(updatedUser.getPasswordHash());
        }

        this.userRepository.save(user);
        return "redirect:/users";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public String createUser(User user) {
        return "users/create-user";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public String storeUser(@Valid User user, BindingResult bindingResult) {
        GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_USER")};
        user.setRoles(Arrays.asList(userRoles));
        this.userRepository.save(user);

        return "redirect:/users";
    }


    @RequestMapping(value = "/users/{id}/remove", method = RequestMethod.GET)
    public String removeUser(@PathVariable("id") long id) {
        if(this.userRepository.findById(id) == null) {
            return "error";
        }

        this.userRepository.delete(id);

        return "redirect:/users";
    }

}