package com.vilin.demo.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String type;
    public User(String id){
        this.id = id;
    }
}
