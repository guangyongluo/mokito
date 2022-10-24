package com.vilin.demo.service;

import com.vilin.demo.dao.PeopleDao;
import com.vilin.demo.entity.People;

public class PeopleService {

    private PeopleDao peopleDao;

    public PeopleService(PeopleDao peopleDao){
        this.peopleDao = peopleDao;
    }

    public void insertPeople(People people){
        peopleDao.insertPeople(people);
    }
}
