package com.klef.sih.service;

import java.util.List;

import com.klef.sih.entity.User;

public interface UserService 
{

    User addUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    User getUserByEmail(String email);
}