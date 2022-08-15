package com.wallet.main.repositories;

import com.wallet.main.entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private final static String EMAIL="carlos.charao@gmail.com";
    @Autowired
    private UserRepository repository;

    @Before
    public void setUp(){
        User user = new User();
        user.setName("Carlos");
        user.setEmail(EMAIL);
        user.setPassword("teste123");
        repository.save(user);
    }

    @After
    public void tearDown(){
        repository.deleteAll();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setName("Carlos");
        user.setEmail(EMAIL);
        user.setPassword("teste123");

        User userResponse = repository.save(user);
        assertNotNull(userResponse);
    }

    @Test
    public void findByEmail(){
        Optional<User> user = repository.findByEmail(EMAIL);
        assertTrue(user.isPresent());
        assertEquals(user.get().getEmail(), EMAIL);
    }
}
