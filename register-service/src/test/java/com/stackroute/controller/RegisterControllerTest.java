//package com.stackroute.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.model.User;
//import com.stackroute.service.RegisterService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.http.RequestEntity.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//class RegisterControllerTest {
//    @Autowired
//    public MockMvc mockMvc;
//
//   @Mock
//    RegisterService registerService;
//   User user;
//   private List<User> userList;
//
//   @InjectMocks
//    RegisterController registerController;
//    @BeforeEach
//    public void setUp()
//    {
//        User user = new User("alfa@gmail.com","12","12");
//        mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
//    }
//
//    @Test
//    public  void givenusertosaveshouldsaveuser() throws Exception {
//        when(registerService.saveUser(any())).thenReturn(user);
//        mockMvc.perform(post("/addUser")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(user)))
//                .andExpect(status().isCreated());
//        verify(registerService,times(1)).saveUser(any());
//    }
//    public static String asJsonString(final  Object obj) {
//        try {
//            return  new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}