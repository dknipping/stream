package com.ted.stream.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ted.stream.mongo.entity.User;
import com.ted.stream.mongo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserServiceTest {

    @Autowired
    private UserService service;

    @After
    public void after() {
        service.removeAll();
    }

    @Test
    public void test() {
        User user = new User();
        user.setFirstName("Hans");
        user.setLastName("Mülller");
        user.setUsername("hmueller");
        user.setPassword("test");

        User persistedUser = service.createUser(user);
        assertNotNull(persistedUser);
        assertNotNull(persistedUser.getId());

        List<User> findAll = service.findAll();
        assertNotNull(findAll);
        assertEquals(1, findAll.size());

        persistedUser.setLastName("Müller");
        persistedUser = service.updateUser(persistedUser);
        
        findAll = service.findAll();
        assertEquals(1, findAll.size());
        assertEquals("Müller", persistedUser.getLastName());
        
        User login = service.login("hmueller", "test");
        assertNotNull(login);
    }
}
