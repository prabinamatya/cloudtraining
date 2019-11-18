package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private UserController userController;
    
    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void testReturnOfValue(){

        List<User> actual = userController.getAllUsers();

        assertNotNull(actual);
        
        assertEquals(10, actual.size());
        assertEquals("Shanna@melissa.tv", actual.get(1).getEmail());
    }
    
    
    @Test
    public void testApiGetAllUsers() {
    	ResponseEntity<List> usersActual = testRestTemplate.getForEntity("/users", List.class);
    	
    	assertNotNull(usersActual);
    }

    @Test
    public void testApiGetUsersById() {
        User user3 = userController.getUserById(3);
        assertNotNull(user3);
        assertEquals("Clementine Bauch", user3.getName());
    }
}
