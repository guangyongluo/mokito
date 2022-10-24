package com.vilin.demo.dao;

import com.vilin.demo.entity.Person;

public class PersonDao {

  public Person findPersonById(Integer id) {
    throw new UnsupportedOperationException("unsupported find operator");
  }

  public Boolean insertPerson(Person person) {
    throw new UnsupportedOperationException("unsupported insert operator");
  }

  public static Boolean updatePerson(Person person) {
    throw new UnsupportedOperationException("unsupported update operator");
  }

  public static void deletePersonById(Integer id) {
    throw new UnsupportedOperationException("unsupported delete operator");
  }

  public void createPerson(Integer id) {
    throw new UnsupportedOperationException("unsupported create operator");
  }
}
