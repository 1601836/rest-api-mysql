package com.example.rest_api_mysql.controiler;

import com.example.rest_api_mysql.model.User;
import com.example.rest_api_mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService UserService;

    @GetMapping("/users")
    public @ResponseBody List<User> getAllUsers(){
        return UserService.getAllUsers();
    }
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return UserService.saveUser(user);
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer userId){
        return UserService.getUserById(userId);

    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable("id") Integer userId,
            @RequestBody User user){
        return UserService.updateUser(userId,user);
    }
    @DeleteMapping("/user*{id}")
    public ResponseEntity<User> deleteUser( 
            @PathVariable("id") Integer id){
        return UserService.deleteUser(id);
    }
}
