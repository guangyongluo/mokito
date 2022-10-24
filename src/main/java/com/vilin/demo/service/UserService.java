package com.vilin.demo.service;

import com.vilin.demo.dao.UserDao;
import com.vilin.demo.entity.User;

public class UserService {

  private UserDao userDao;

  public UserService(UserDao userDao) {
    this.userDao = userDao;
  }

  public User findUserById(Long id) {
    return userDao.findUserById(id);
  }

  public void insertUser(User user) {
    userDao.insertUser(user);
  }

  public boolean deleteUser(User user) {
    user.setType("D");
    return this.userDao.deleteUser(user);
  }
}
