package com.vilin.demo.test;

import com.vilin.demo.service.SimpleService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WildcardArgumentTest {

  @Mock private SimpleService simpleService;

  @Test
  public void wildcardMethod1() {
    when(simpleService.method1(anyInt(), anyString(), anyCollection(), isA(Serializable.class)))
        .thenReturn(100);
    assertThat(simpleService.method1(1, "luo", Collections.emptyList(), "wei"), equalTo(100));

    reset(simpleService);

    when(simpleService.method1(anyInt(), anyString(), anyCollection(), isA(Serializable.class)))
            .thenReturn(-1);
    when(simpleService.method1(anyInt(), eq("luo"), anyCollection(), isA(Serializable.class)))
        .thenReturn(200);
    when(simpleService.method1(anyInt(), eq("wei"), anyCollection(), isA(Serializable.class)))
        .thenReturn(500);

    assertThat(simpleService.method1(1, "luo", Collections.emptyList(), "hahaha"), equalTo(200));
    assertThat(simpleService.method1(1, "wei", Collections.emptyList(), "xixixi"), equalTo(500));
    assertThat(simpleService.method1(1, "xxx", Collections.emptyList(), "hehehe"), equalTo(-1));

  }

  @Test
  public void wildcardMethod2() {
    List<Object> emptyList = Collections.emptyList();
    doNothing()
        .when(simpleService)
        .method2(any(), anyString(), anyCollection(), isA(Serializable.class));
    simpleService.method2(1, "luo", emptyList, "wei");
    verify(simpleService, times(1)).method2(1, "luo", emptyList, "wei");
    verify(simpleService, times(1))
        .method2(anyInt(), anyString(), anyCollection(), isA(Serializable.class));
  }

  @After
  public void destory() {
    reset(simpleService);
  }
}
