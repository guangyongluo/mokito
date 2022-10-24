package com.vilin.demo.util;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class CompareNumber<T extends Number> extends BaseMatcher<T> {

  private T value;

  private Compare<T> compare;

  public CompareNumber(T value, boolean great) {
    this.compare = new DefaultCompareNumber<>(great);
    this.value = value;
  }

  @Override
  public boolean matches(Object actual) {
    return compare.compare(value, (T) actual);
  }

  public static <T extends Number> CompareNumber<T> gt(T value) {
    return new CompareNumber<>(value, true);
  }

  public static <T extends Number> CompareNumber<T> lt(T value) {
    return new CompareNumber<>(value, false);
  }

  interface Compare<T extends Number> {
    boolean compare(T expected, T actual);
  }

  private static class DefaultCompareNumber<T extends Number> implements Compare<T> {

    private boolean great;

    public DefaultCompareNumber(boolean great) {
      this.great = great;
    }

    @Override
    public boolean compare(T expected, T actual) {

      Class<?> actualClass = actual.getClass();
      if (actualClass == Integer.class) {
        return great
            ? (Integer) actual > (Integer) expected
            : (Integer) actual < (Integer) expected;
      } else if (actualClass == Byte.class) {
        return great ? (Byte) actual > (Byte) expected : (Byte) actual < (Byte) expected;
      } else if (actualClass == Short.class) {
        return great ? (Short) actual > (Short) expected : (Short) actual < (Short) expected;
      } else if (actualClass == Long.class) {
        return great ? (Long) actual > (Long) expected : (Long) actual < (Long) expected;
      } else if (actualClass == Float.class) {
        return great ? (Float) actual > (Float) expected : (Float) actual < (Float) expected;
      } else if (actualClass == Double.class) {
        return great ? (Double) actual > (Double) expected : (Double) actual < (Double) expected;
      } else {
        throw new AssertionError("The Number type : " + actual.getClass() + " is not supported");
      }
    }
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("compare two numbers");
  }
}
