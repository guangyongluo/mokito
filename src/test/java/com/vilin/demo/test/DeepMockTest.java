package com.vilin.demo.test;

import com.vilin.demo.entity.Mocker;
import com.vilin.demo.service.MockerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DeepMockTest {

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private MockerService mockerService;

  //  @Mock private Mocker mocker;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testMock() {
    //    when(mockerService.getMocker()).thenReturn(mocker);
    Mocker mocker = mockerService.getMocker();
    mocker.foo();
  }
}
