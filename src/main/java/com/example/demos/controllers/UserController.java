package com.example.demos.controllers;

import com.example.demos.dto.UserDto;
import com.example.demos.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/user")
public class UserController {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserService userService;


    @GetMapping("/signin")
    public String getSignIn(Model model){
        model.addAttribute("userDto", new UserDto());
        return "signin";
    }
 
    @GetMapping("/signup")
    public String getSignUp(Model model){
        model.addAttribute("userDto", new UserDto());
        return "signup";
    }

    // @PostMapping("/signin")
    // public String signIn(UserDto userDto, Model model){
    //     return "redirect:/flights";
    // }

    @PostMapping("/signup")
    public String signUp(UserDto userDto, Model model){
        LOG.info("Post signin {}", userDto.username);
        userService.createUser(userDto);
        return "redirect:/signin";
    }
}

