package com.example.rest_api_mysql.service;

import com.example.rest_api_mysql.model.User;
import com.example.rest_api_mysql.repository.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<User> saveUser(User user){
        return new ResponseEntity<>(userRepository.save(user),HttpStatus.CREATED);
    }

    public User getUserById(Integer id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        }else{
            throw new RuntimeException();
        }
    }
    public  ResponseEntity<User>updateUser(Integer id,User user){
        User findUser = userRepository.findById(id).orElseThrow();

        findUser.setName(user.getName());
        findUser.setLastname(user.getLastname());

        return new ResponseEntity<>(userRepository.save(findUser),HttpStatus.OK);
    }

    public ResponseEntity<User> deleteUser(Integer id){
        User findUser = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
        return new ResponseEntity<>(findUser, HttpStatus.OK);
    }
}
