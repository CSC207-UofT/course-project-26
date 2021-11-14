package service;

import Entity.User;

import java.util.List;

public interface UserService {
     List<User> findAll();

     User getStudentByUsername(String username);

     void saveOrUpdate(User user);

     void deleteByUsername(String username);
}
