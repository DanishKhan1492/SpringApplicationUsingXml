package com.springapplicationusingxml.controllers;

import com.springapplicationusingxml.Services.UserService;
import com.springapplicationusingxml.entities.User;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by muhamamddanish on 9/30/16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private final static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/manipulateUser", method = RequestMethod.POST)
    public String userForm(@Valid @ModelAttribute User user, BindingResult result, Model model,RedirectAttributes redirectAttributes){
        logger.debug("In userForm Method");

        List<User> userList = userService.getUsers();
        model.addAttribute("users",userList);

        if(result.hasErrors()){
            logger.info("Found Some Errors after Validation in Information Provided by User");
            logger.info("So Redirecting");
            return "add-editUser";
        }else{
            if(user.getUserId() == 0){
                userService.insertUser(user);
                redirectAttributes.addFlashAttribute("success","User Inserted Successfully");
            }else if(user.getUserId() > 0 ){
                userService.updateUser(user);
                redirectAttributes.addFlashAttribute("update","User Updated Successfully");
            }
            return "redirect:manipulateUserPage";
        }
    }

    @RequestMapping(value ="/editUser/{firstName}", method = RequestMethod.GET)
    public String editUser(@PathVariable("firstName") String firstName, Model model){
        User user =  new User();
        user =  userService.getUser(firstName);

        List<User> userList = userService.getUsers();
        model.addAttribute("users",userList);
        if(user != null){
            model.addAttribute("user",user);
        }else{
            model.addAttribute("user",new User());
        }


        return "add-editUser";
    }

    @RequestMapping(value="/deleteUser/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") int userId, Model model,RedirectAttributes redir){

        userService.deleteUser(userId);

        redir.addFlashAttribute("deleted","User Deleted Successfully");
        return "redirect:manipulateUserPage";
    }

}
