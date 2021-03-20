package com.stackroute.controller;


import com.stackroute.model.ProjectDto;
import com.stackroute.model.User;
import com.stackroute.repository.ProjectRepository;
import com.stackroute.service.USerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
@CrossOrigin(origins="*")
@RestController
public class ProfileController {

   public USerService userService;

    @Autowired
    public ProfileController(USerService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{emailId}")
    public User getAllUser(@PathVariable String emailId)
    {
        return  userService.getAllUser(emailId);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }



    @PutMapping("/updateUser/{emailId}")
    public User editProfile(@PathVariable String emailId, @RequestBody User user)
    {
       return userService.updateUser(user,emailId);
    }
    @GetMapping("/project/{emailId}")
    public ProjectDto getProject(@PathVariable String emailId)
    {
        return userService.getProject(emailId);
    }


}
