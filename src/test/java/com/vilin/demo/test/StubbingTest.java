package com.vilin.demo.test;

import com.vilin.demo.service.SubbingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {

  private List<String> list;

  @Before
  public void init() {
    list = mock(ArrayList.class);
  }

  @Test
  public void howToUseStabbing() {
    when(list.get(0)).thenReturn("first");
    assertThat(list.get(0), equalTo("first"));

    when(list.get(anyInt())).thenThrow(new RuntimeException());
    try {
      list.get(0);
      fail();
    } catch (Exception e) {
      assertThat(e, instanceOf(RuntimeException.class));
    }
  }

  @Test
  public void howToUseStabbingVoidMethod() {
    doNothing().when(list).clear();
    list.clear();
    verify(list, times(1)).clear();

    doThrow(RuntimeException.class).when(list).clear();
    try {
      list.clear();
      fail();
    } catch (Exception e) {
      assertThat(e, instanceOf(RuntimeException.class));
    }
  }

  @Test
  public void subbingDoReturn() {
    when(list.get(0)).thenReturn("first");
    doReturn("second").when(list).get(1);
    assertThat(list.get(0), equalTo("first"));
    assertThat(list.get(1), equalTo("second"));
  }

  @Test
  public void iterateSubbing() {
//        when(list.size()).thenReturn(1,2,3,4);
//        when(list.size()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4);
//    doReturn(1).doReturn(2).doReturn(3).doReturn(4).when(list).size();
    assertThat(list.size(), equalTo(1));
    assertThat(list.size(), equalTo(2));
    assertThat(list.size(), equalTo(3));
    assertThat(list.size(), equalTo(4));
    assertThat(list.size(), equalTo(4));
  }

  @Test
  public void subbingWithAnswer() {
    when(list.get(anyInt()))
        .thenAnswer(
            invocation -> {
              Integer index = invocation.getArgumentAt(0, Integer.class);
              return String.valueOf(index * 10);
            });

    assertThat(list.get(1), equalTo("10"));
    assertThat(list.get(9), equalTo("90"));
    assertThat(list.get(999), equalTo("9990"));
  }

  @Test
  public void subbingWithRealCall() {
    SubbingService mock = mock(SubbingService.class);
    System.out.println(mock.getClass());
    mock.getS();

    System.out.println(mock.getI());

    when(mock.getS()).thenReturn("Leo");
    assertThat(mock.getS(), equalTo("Leo"));

    when(mock.getI()).thenCallRealMethod();
    assertThat(mock.getI(), equalTo(10));

    doCallRealMethod().when(mock).getI();
    assertThat(mock.getI(), equalTo(10));
  }

  @After
  public void destory() {
    reset();
  }
}
