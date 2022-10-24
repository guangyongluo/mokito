package com.vilin.demo.test;

import org.junit.Test;

import static com.vilin.demo.util.CompareNumber.gt;
import static com.vilin.demo.util.CompareNumber.lt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimpleTest {

  @Test
  public void test() {
    int i = 10;
    assertThat(i, gt(9));
    assertThat(i, lt(11));
  }

  @Test
  public void testMatcherByMockito() {
    assertThat(10, greaterThan(9));
    assertThat(10, lessThan(11));
    assertThat(10, greaterThanOrEqualTo(10));
    assertThat(10, lessThanOrEqualTo(10));
  }
}
