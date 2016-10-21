package com.springapplicationusingxml.controllers;

import com.springapplicationusingxml.Services.UserService;
import com.springapplicationusingxml.entities.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by muhammadkhan on 10/2/16.
 */
@Controller
public class NavigationController {

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(NavigationController.class.getName());

    @RequestMapping("/manipulateUserPage")
    public String manipulateUserPage(Model model){
        logger.info("manipulateUserPage Method");
        logger.info("Directing to page so that user can insert new or edit old info");
        model.addAttribute("user",new User());

        List<User> userList = userService.getUsers();
        model.addAttribute("users",userList);

        return "add-editUser";
    }
}
