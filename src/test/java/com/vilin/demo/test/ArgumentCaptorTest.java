package com.vilin.demo.test;

import com.vilin.demo.dao.UserDao;
import com.vilin.demo.entity.User;
import com.vilin.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class ArgumentCaptorTest {

  @Mock private List<String> list;

  @Mock private UserDao userDao;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testSimpleCaptor() {
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    //        when(list.add("Mockito")).thenReturn(true);
    list.add("Mockito");
    //        verify(list, times(1)).add("Mockito");
    verify(list, times(1)).add(captor.capture());
    assertThat(captor.getValue(), equalTo("Mockito"));
  }

  @Test
  public void testArgumentCaptor() {
    ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
    UserService userService = new UserService(userDao);
    User user = new User("12345");

    when(userDao.deleteUser(user)).thenReturn(true);
    assertThat(userService.deleteUser(user), equalTo(true));
    verify(userDao).deleteUser(captor.capture());

    assertThat(captor.getValue().getType(), equalTo("D"));
    assertThat(user.getType(), equalTo("D"));
  }
}
