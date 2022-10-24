package com.vilin.demo.test;

import com.vilin.demo.dao.AccountDao;
import com.vilin.demo.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockByAnnotationTest {

  @Before
  public void init() {
    System.out.println("init()");
    MockitoAnnotations.initMocks(this);
  }

  @Mock(answer = Answers.RETURNS_SMART_NULLS)
  private AccountDao accountDao;

  @Test
  public void testMock() {
    System.out.println("mock()");
    Account account = accountDao.findAccount("x", "x");
    System.out.println(account);
  }
}
