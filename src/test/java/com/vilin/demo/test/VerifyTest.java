package com.vilin.demo.test;

import com.vilin.demo.dao.VerifyDao;
import com.vilin.demo.entity.Verify;
import com.vilin.demo.service.VerifyService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class VerifyTest {

  @Mock private VerifyDao verifyDao;

  @Before
  public void init() {
    System.out.println("init()");
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCallUpdate() {
    // Given
    Verify verify = new Verify();
    VerifyService verifyService = new VerifyService(verifyDao);

    // When
    when(verifyDao.findVerify(verify)).thenReturn(false);
    when(verifyDao.updateVerify(verify)).thenReturn(true);
    when(verifyDao.insertVerify(verify)).thenReturn(true);

    boolean result = verifyService.merge(verify);

    // Then
    assertThat(result, equalTo(true));
    verify(verifyDao, times(0)).updateVerify(verify);
    verify(verifyDao, times(1)).insertVerify(verify);
  }

  @Test
  public void testCallInsert() {
    // Given
    Verify verify = new Verify();
    VerifyService verifyService = new VerifyService(verifyDao);

    // When
    when(verifyDao.findVerify(verify)).thenReturn(true);
    when(verifyDao.updateVerify(verify)).thenReturn(true);
    when(verifyDao.insertVerify(verify)).thenReturn(true);

    boolean result = verifyService.merge(verify);

    // Then
    assertThat(result, equalTo(true));
    verify(verifyDao, times(1)).updateVerify(verify);
    verify(verifyDao, times(0)).insertVerify(verify);
  }

  @Test
  public void testCallInsertAndUpdate() {
    // Given
    Verify verify = new Verify();
    VerifyService verifyService = new VerifyService(verifyDao);

    // When
    //        when(verifyDao.findVerify(verify)).thenReturn(true).thenReturn(false);
    when(verifyDao.findVerify(verify)).thenReturn(true, false);
    when(verifyDao.updateVerify(verify)).thenReturn(true);
    when(verifyDao.insertVerify(verify)).thenReturn(true);

    boolean result = verifyService.merge(verify);

    // Then
    assertThat(result, equalTo(true));
    verify(verifyDao, times(1)).updateVerify(verify);
    verify(verifyDao, times(0)).insertVerify(verify);

    // when
    result = verifyService.merge(verify);

    // Then
    assertThat(result, equalTo(true));
    verify(verifyDao, times(1)).updateVerify(verify);
    verify(verifyDao, times(1)).insertVerify(verify);
  }

  @After
  public void tearDown() {
    reset(verifyDao);
  }
}
