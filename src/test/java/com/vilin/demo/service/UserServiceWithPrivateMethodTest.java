package com.vilin.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserServiceWithPrivateMethod.class)
public class UserServiceWithPrivateMethodTest {

    @Test
    public void foo() {
      UserServiceWithPrivateMethod userServiceWithPrivateMethod = PowerMockito.spy(new UserServiceWithPrivateMethod());
      userServiceWithPrivateMethod.foo();
    }

    @Test
    public void testPrivateMethod() throws Exception {
        UserServiceWithPrivateMethod spy = PowerMockito.spy(new UserServiceWithPrivateMethod());
        doNothing().when(spy, "exist");
        spy.callExist();
        verifyPrivate(spy, times(1));
    }

    @Test
    public void testPrivateMethodWithParam() throws Exception {
        UserServiceWithPrivateMethod spy = PowerMockito.spy(new UserServiceWithPrivateMethod());
        PowerMockito.doReturn(2).when(spy, "number", "123");
        int result = spy.callNumber("123");
        assertThat(2, equalTo(result));
    }
}