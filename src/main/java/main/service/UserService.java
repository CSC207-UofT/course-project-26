package main.service;

import main.entity.User;

import java.util.List;

public interface UserService {
     List<User> findAll();

     User getStudentByUsername(String username);

     void saveOrUpdate(User user);

     void deleteByUsername(String username);
}