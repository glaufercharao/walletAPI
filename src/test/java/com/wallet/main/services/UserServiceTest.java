package com.wallet.main.services;

import com.wallet.main.entities.User;
import com.wallet.main.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Before
    public void setUp(){
        BDDMockito.given(userRepository.findByEmail(Mockito.anyString())).willReturn(Optional.of(new User()));
    }

    @Test
    public void testeFindByEmail(){
        Optional<User> user = userService.findByEmail("teste@gmail.com");
        assertTrue(user.isPresent());
    }
}