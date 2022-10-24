package com.vilin.demo.service;

public class UserServiceWithPrivateMethod {

    public void foo(){
        log();
    }

    private void log(){
        System.out.println("I am console log");
    }

    public void callExist(){
        exist();
    }

    private void exist(){
        throw new UnsupportedOperationException("UnsupportedOperationException");
    }

    public int callNumber(String str){
        return number(str);
    }

    private int number(String str){
        throw new UnsupportedOperationException("UnsupportedOperationException");
    }
}
