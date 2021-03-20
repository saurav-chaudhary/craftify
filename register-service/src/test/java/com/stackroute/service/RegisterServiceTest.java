package com.stackroute.service;

import com.stackroute.model.User;
import com.stackroute.repository.ResgisterRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith({MockitoExtension.class})
class RegisterServiceTest {
    @Mock
    ResgisterRepository resgisterRepository;

    @InjectMocks
    RegisterService registerService;
    @Test
    public  void givenusershouldreturnsavedsuser()
    {
        User user = new User("alfa@gmail.com","12","12");
        when(resgisterRepository.save(any())).thenReturn(user);
        resgisterRepository.save(user);
        verify(resgisterRepository,times(1)).save(any());

    }

}