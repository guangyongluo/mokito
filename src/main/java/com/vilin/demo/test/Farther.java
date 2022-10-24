package com.vilin.demo.test;

import java.util.Arrays;
import java.util.List;

public class Farther {
  public void fun() {}

  public static void main(String[] args) {
    boolean flag = true;
    if (flag) {}

    try {
      int i = 10 / 0;
    } catch (Exception e) {
      e.printStackTrace();
    }

    List list = Arrays.asList(1, 2, 3, 4, 5);
    for (Object o : list) {
      System.out.println(o);
    }

    for (int i = 0; i < list.size(); i++) {}
  }
}
