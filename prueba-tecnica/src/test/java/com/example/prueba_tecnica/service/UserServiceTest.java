package com.example.prueba_tecnica.service;

import com.example.prueba_tecnica.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    public void testGetUsers() {
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        UserService userService = new UserService(restTemplate);

        User[] mockUsers = {new User()};
        mockUsers[0].setId(1L);
        mockUsers[0].setName("Test User");

        when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class))
                .thenReturn(mockUsers);

        List<User> users = userService.getUsers();
        assertEquals(1, users.size());
        assertEquals("Test User", users.get(0).getName());
    }
}
