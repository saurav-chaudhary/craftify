//package com.stackroute.repository;
//
//
//import com.stackroute.model.User;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class ResgisterRepositoryTest {
//    @Autowired
//    ResgisterRepository resgisterRepository;
//
//    @Test
//    public void givenUserToSaveUser() {
//        User user = new User("saurav@gmail.com", "123", "123");
//        resgisterRepository.save(user);
//        User user1 = resgisterRepository.findByEmailId(user.getEmailId());
//        assertNotNull(user1);
//        assertEquals(user1.getEmailId(),user.getEmailId());
//    }
//
//
//    @Test
//    public  void getallusershouldreturnlistofuser()
//    {
//        User user = new User("alfa@gmail.com","12","12");
//        User user1 = new User("chaudhary@gmail.com","12","12");
//        resgisterRepository.save(user);
//        resgisterRepository.save(user1);
//
//        List<User> userList = (List<User>) resgisterRepository.findAll();
//        assertEquals("alfa@gmail.com",userList.get(0).getEmailId());
//    }
//}