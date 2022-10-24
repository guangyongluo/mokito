package com.vilin.demo.test;

import com.vilin.demo.dao.AccountDao;
import com.vilin.demo.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {

  @Test
  public void testMock() {
    AccountDao accountdao = mock(AccountDao.class);
    Account account = accountdao.findAccount("x", "y");
    System.out.println(account);
  }
}
