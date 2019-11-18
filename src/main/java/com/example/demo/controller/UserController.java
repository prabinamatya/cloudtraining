package com.example.demo.controller;

import com.example.demo.RestClientContext;
import com.example.demo.models.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    final String URI = "https://jsonplaceholder.typicode.com/users";

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;


    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {


        ResponseEntity<User[]> userEntity = restTemplate.getForEntity(URI, User[].class);

        List<User> userList = Arrays.asList(userEntity.getBody());

        return userList;
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@RequestParam int id) {

        User[] userArray = restTemplate.getForObject(URI, User[].class);
        List<User> users = Arrays.asList(userArray);
        Optional<User> first = Optional.of(users.stream().filter(e -> e.getId().equals(id)).findFirst().get());


        return first.get();
    }

}
