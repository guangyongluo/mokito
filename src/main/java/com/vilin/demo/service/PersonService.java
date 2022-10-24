package com.vilin.demo.service;

import com.vilin.demo.dao.PersonDao;
import com.vilin.demo.entity.Person;

public class PersonService {

  public Person findPersonById(Integer id) {
    PersonDao personDao = new PersonDao();
    return personDao.findPersonById(id);
  }

  public Boolean insertPerson(Person person) {
    PersonDao personDao = new PersonDao();
    return personDao.insertPerson(person);
  }

  public Boolean updatePerson(Person person) {
    return PersonDao.updatePerson(person);
  }

  public void deletePersonById(Integer id) {
    PersonDao.deletePersonById(id);
  }

  public void createPerson(Integer id){
    PersonDao personDao = new PersonDao();
    personDao.createPerson(id);
  }
}
