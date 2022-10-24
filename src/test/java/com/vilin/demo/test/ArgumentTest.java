package com.vilin.demo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.*;

public class ArgumentTest {

  @Test
  public void basicTest() {
    List<Integer> list = mock(ArrayList.class);

    when(list.get(0)).thenReturn(100);

    assertThat(list.get(0), equalTo(100));
    assertThat(list.get(1), nullValue());
  }

  @Test
  public void complexTest() {
    Foo foo = mock(Foo.class);

    when(foo.function(isA(Parent.class))).thenReturn(100);

    assertThat(foo.function(new Child1()), equalTo(100));
    assertThat(foo.function(new Child2()), equalTo(100));

    reset(foo);

    when(foo.function(isA(Child1.class))).thenReturn(100);

    assertThat(foo.function(new Child1()), equalTo(100));
    assertThat(foo.function(new Child2()), equalTo(0));

    reset(foo);

    when(foo.function(any(Child1.class))).thenReturn(100);

    assertThat(foo.function(new Child1()), equalTo(100));
    assertThat(foo.function(new Child2()), equalTo(100));

  }

  // strategy pattern
  static class Foo {
    public int function(Parent parent) {
      return parent.work();
    }
  }

  interface Parent {
    int work();
  }

  class Child1 implements Parent {

    @Override
    public int work() {
      throw new RuntimeException();
    }
  }

  class Child2 implements Parent {

    @Override
    public int work() {
      throw new RuntimeException();
    }
  }
}
