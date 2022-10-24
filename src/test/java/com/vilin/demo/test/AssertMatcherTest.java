package com.vilin.demo.test;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertMatcherTest {

  @Test
  public void test() {
    int i = 10;

    assertThat(i, equalTo(10));

    assertThat(i, not(equalTo(20)));

    assertThat(i, is(10));

    assertThat(i, not(is(20)));

    double d = 1.23;

    assertThat(d, either(equalTo(1.23)).or(equalTo(3.33)));
    assertThat(d, both(equalTo(1.23)).and(not(equalTo(3.33))));

    assertThat(d, anyOf(equalTo(1.23), equalTo(2.33), equalTo(3.33)));
    assertThat(d, anyOf(equalTo(1.23), not(equalTo(2.33)), not(equalTo(3.33))));

    assertThat(d, allOf(is(1.23), is(not(2.33)), is(not(3.33))));

    assertThat(Stream.of(1, 2, 3).allMatch(j -> j > 0), equalTo(true));
    assertThat(Stream.of(1, 2, 3).anyMatch(j -> j > 1), equalTo(true));
  }

  @Test
  public void failTest() {
    double price = 3.88;

    assertThat("the price is wrong", price, either(equalTo(1.23)).or(equalTo(3.33)));

  }
}
