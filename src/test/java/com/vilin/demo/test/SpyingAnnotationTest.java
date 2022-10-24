package com.vilin.demo.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

public class SpyingAnnotationTest {

  @Spy private List list = new ArrayList<>();

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void spyingTest() {
    list.add("Mockito");
    list.add("powerMock");

    assertThat(list.get(0), equalTo("Mockito"));
    assertThat(list.get(1), equalTo("powerMock"));
    assertThat(list.isEmpty(), equalTo(false));

    when(list.isEmpty()).thenReturn(true);
    when(list.size()).thenReturn(0);
    assertThat(list.get(0), equalTo("Mockito"));
    assertThat(list.get(1), equalTo("powerMock"));
    assertThat(list.isEmpty(), equalTo(true));
    assertThat(list.size(), equalTo(0));
  }
}
