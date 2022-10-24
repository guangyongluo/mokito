package com.vilin.demo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class VerificationTest {

  @Mock private List<String> list;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
//    list.add("Mockito");
//    verify(list).add("Mockito");
  }

  @Test
  public void test1() {
    list.add("Mockito");

    verify(list).add("Mockito");
    verify(list, times(0)).size();
    verify(list, atMost(1)).add("Mockito");
    verify(list, never()).clear();

    list.add("Mockito");
    list.add("Mockito");

    verify(list, atLeastOnce()).add("Mockito");
    verify(list, atLeast(2)).add("Mockito");
    verify(list, atMost(3)).add("Mockito");
  }

  /**
   * This is used to verify that only one method is called on a mock. It fails if any other method
   * is called on the mock object.
   *
   * <p>only one method exactly(if call other mock object method will be verified failed.)
   *
   * <p>only one method and call once
   */
  @Test
  public void test2() {
    list.add("Mockito");
    //list.add("Mockito");
    //list.clear();//failed
    verify(list, only()).add("Mockito");
  }

  @Test
  public void test3() {

//    verifyZeroInteractions(list);

    list.add("Mockito");
    verify(list, times(2)).add("Mockito");


    list.clear();
    verify(list).clear();


    list.size();
    verify(list).size();

    verifyNoMoreInteractions(list);

//    list.size();
//    verify(list, times(2)).size();

  }

  @After
  public void tearDown(){
    reset(list);
  }
}
