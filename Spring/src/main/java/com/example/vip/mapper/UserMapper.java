package com.example.vip.mapper;

import com.example.vip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, Long> {

    User findByNameAndPass(String name, String pass);






}
