package com.stackroute.service;

import com.stackroute.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.repository.ResgisterRepository;

@Service
public class RegisterService {
    ResgisterRepository resgisterRepository;
    @Autowired
    public RegisterService(ResgisterRepository resgisterRepository) {
        this.resgisterRepository = resgisterRepository;
    }


    public User fetchUserByEmailID(String tempEmail) {
        return resgisterRepository.findByEmailId(tempEmail);
    }

    public User saveUser(User user) {
        return resgisterRepository.save(user);
    }
}
