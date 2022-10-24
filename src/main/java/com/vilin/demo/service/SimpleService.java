package com.vilin.demo.service;

import java.io.Serializable;
import java.util.Collection;

public class SimpleService {

  public int method1(Integer i, String s, Collection<?> c, Serializable serializable) {
    throw new RuntimeException();
  }

  public void method2(Integer i, String s, Collection<?> c, Serializable serializable) {
    throw new RuntimeException();
  }
}
