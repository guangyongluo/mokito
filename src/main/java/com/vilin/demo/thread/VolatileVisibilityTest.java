package com.vilin.demo.thread;

import java.util.concurrent.TimeUnit;

public class VolatileVisibilityTest {

  private static volatile boolean initFlag = true;

  public static void main(String[] args) throws InterruptedException {
    new Thread(
            () -> {
              System.out.println("waiting data:");
              while (initFlag) {}
              System.out.println("==success==");
            })
        .start();

    TimeUnit.MILLISECONDS.sleep(100);

    new Thread(
            () -> {
              System.out.println("update data.");
              initFlag = false;
              System.out.println("store in memory");
            })
        .start();
  }
}
