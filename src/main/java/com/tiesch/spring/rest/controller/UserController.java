package com.tiesch.spring.rest.controller;

import com.tiesch.spring.rest.model.User;
import com.tiesch.spring.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/addUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "info";
    }

    @RequestMapping("/deleteInfo")
    public String deleteUser(@RequestParam("userId") int id) {

        userService.deleteUser(id);

        return "redirect:/users";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("userId") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.addUser(user);

        return "redirect:/users";
    }
}
