package com.stackroute.repository;

//import com.stackroute.entity.Project;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class ProjectRepositoryTest {
//
//    @Autowired
//    private ProjectRepository userRepository;
//    @Test
//    public void returnProjectAfterAdding() {
//        Project project = new Project();
//        project.setId(100);
//        project.setUserName("User");
//        userRepository.save(project);
//        Project p= userRepository.findById(project.getId()).get();
//        assertNotNull(p);
//        assertEquals(p.getUserName(), project.getUserName());
//        userRepository.deleteById(100);
//    }
//
//    @Test
//    public void deleteProject(){
//        Project project = new Project();
//        project.setId(100);
//        project.setUserName("User");
//        userRepository.save(project);
//        userRepository.deleteById(100);
//        boolean p=userRepository.findById(project.getId()).isPresent();
////        assertNull(p);
//        assertEquals(p, false);
//    }
//
//    @Test
//    public void findObject(){
//        Project project = new Project();
//        project.setId(100);
//        project.setUserName("User");
//        userRepository.save(project);
//        Project p= userRepository.findById(project.getId()).get();
//        assertNotNull(p);
//        assertEquals(p.getUserName(),"User");
//    }
//}