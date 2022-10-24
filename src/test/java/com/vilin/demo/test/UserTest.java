package com.vilin.demo.test;

import com.vilin.demo.dao.UserDao;
import com.vilin.demo.entity.User;
import com.vilin.demo.service.UserService;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {

  /** do...when...then */
  @Test
  public void findUserByIdTest() {
    UserDao userDao = PowerMockito.mock(UserDao.class);
    UserService userService = new UserService(userDao);
    User user = new User("123456");
    PowerMockito.doReturn(user).when(userDao).findUserById(1l);
    User user1 = userService.findUserById(1l);
    assertThat(user1, equalTo(user));
  }

  @Test
  public void insertUserTest() {
    UserDao userDao = PowerMockito.mock(UserDao.class);
    UserService userService = new UserService(userDao);
    User user = new User("123456");
    PowerMockito.doNothing().when(userDao).insertUser(user);
    userService.insertUser(user);
    Mockito.verify(userDao, Mockito.times(1)).insertUser(user);
  }

  public static void main(String[] args) {
    Map map = new HashMap();
  }

  Boolean flag = true;
}
