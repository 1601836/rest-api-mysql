package com.example.rest_api_mysql.repository;

import com.example.rest_api_mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
