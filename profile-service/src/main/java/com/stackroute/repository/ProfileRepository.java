package com.stackroute.repository;

import com.stackroute.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<User,String> {

    User findByEmailId(String emailId);
}
