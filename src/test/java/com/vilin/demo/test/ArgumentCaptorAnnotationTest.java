package com.vilin.demo.test;

import com.vilin.demo.dao.UserDao;
import com.vilin.demo.entity.User;
import com.vilin.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class ArgumentCaptorAnnotationTest {

  @Mock private List<String> list;

  @Captor private ArgumentCaptor<String> captor;

  @Captor ArgumentCaptor<User> userCaptor;

  @Mock private UserDao userDao;

  @InjectMocks private UserService userService;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testSimpleCaptor() {

    //        when(list.add("Mockito")).thenReturn(true);
    list.add("Mockito");
    //        verify(list, times(1)).add("Mockito");
    verify(list, times(1)).add(captor.capture());
    assertThat(captor.getValue(), equalTo("Mockito"));
  }

  @Test
  public void testArgumentCaptor() {

    //        UserService userService = new UserService(userDao);
    User user = new User("12345");

    when(userDao.deleteUser(user)).thenReturn(true);
    assertThat(userService.deleteUser(user), equalTo(true));
    verify(userDao).deleteUser(userCaptor.capture());

    assertThat(userCaptor.getValue().getType(), equalTo("D"));
    assertThat(user.getType(), equalTo("D"));
  }
  
}
