package com.vilin.demo;

import com.vilin.demo.controller.AccountLoginController;
import com.vilin.demo.dao.AccountDao;
import com.vilin.demo.entity.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerUT {

  private AccountDao accountDao;

  private HttpServletRequest httpServletRequest;

  private AccountLoginController accountLoginController;

  @Before
  public void setUp() {
    this.accountDao = mock(AccountDao.class);
    this.httpServletRequest = mock(HttpServletRequest.class);
    this.accountLoginController = new AccountLoginController(accountDao);
  }

  @Test
  public void LoginSuccessful() {
    Account account = new Account();
    when(httpServletRequest.getParameter("username")).thenReturn("Leo");
    when(httpServletRequest.getParameter("password")).thenReturn("123456");
    when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);

    assertThat(accountLoginController.login(httpServletRequest), equalTo("/index.html"));
  }

  @Test
  public void LoginFail() {
    Account account = new Account();
    when(httpServletRequest.getParameter("username")).thenReturn("Leo");
    when(httpServletRequest.getParameter("password")).thenReturn("123456");
    when(accountDao.findAccount(anyString(), anyString())).thenThrow(Exception.class);

    assertThat(accountLoginController.login(httpServletRequest), equalTo("/505.html"));
  }

  @After
  public void tearDown() {
    Mockito.reset(accountDao);
    Mockito.reset(httpServletRequest);
  }
}
