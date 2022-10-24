package com.vilin.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpyingTest {

  @Test
  public void spyingTest() {
    List<String> realList = new ArrayList<>();
    List<String> list = spy(realList);

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
