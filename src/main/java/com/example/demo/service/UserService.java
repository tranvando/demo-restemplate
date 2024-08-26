package com.example.demo.service;

import com.example.demo.modal.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final String URL = "http://65c05be725a83926ab96327e.mockapi.io/rsupport/users";
    private RestTemplate restTemplate = new RestTemplate();
    public List<User> getList(){
        //RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response  = restTemplate.getForEntity(URL, User[].class);
        return Arrays.asList(response.getBody());
    }

    public User getUserById(Long id){
        ResponseEntity<User> response  = restTemplate.getForEntity(URL + "/"+id, User.class);
        return response.getBody();
    }

    public void deleteUser(Long id){
        restTemplate.delete(URL + "/"+id);
    }

    public void updateUser(User user){
        restTemplate.put(URL,user);
    }

    public User addUser(User user){
        ResponseEntity<User> response  = restTemplate.postForEntity(URL, user, User.class);
        return response.getBody();
    }
}
