package com.stackroute.controller;

import com.stackroute.model.User;
import com.stackroute.service.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.stackroute.service.RegisterService;

@CrossOrigin(origins="*")
@RestController
public class RegisterController {

   private RegisterService registerService;
    private   RabbitSender rabbitSender;


   @Autowired
    public RegisterController(RegisterService registerService, RabbitSender rabbitSender) {
        this.registerService = registerService;
        this.rabbitSender = rabbitSender;
    }






    @PostMapping("/addUser")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmailId();
        if(!user.getPassword().equals(user.getConfirmPassword()))
        {
            throw new Exception(" please check your password");
            //return new ResponseEntity<String>("failed", HttpStatus.CREATED);
        }
        if(tempEmail !=null && !"" .equals(tempEmail) )
        {
            User userObj = registerService.fetchUserByEmailID(tempEmail);
            if(userObj != null)
            {
                throw new Exception(" user with "+ tempEmail+" is already exist");
            }
        }
        rabbitSender.send(user);
        User saveUser = registerService.saveUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

}
