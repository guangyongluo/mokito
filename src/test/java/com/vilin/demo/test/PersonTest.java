package com.vilin.demo.test;

import com.vilin.demo.dao.PersonDao;
import com.vilin.demo.entity.Person;
import com.vilin.demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PersonService.class, PersonDao.class})
public class PersonTest {

  @Test
  public void findPersonByIdTest() throws Exception {
    PersonService personService = new PersonService();
    Person person = new Person();
    person.setId(100000);
    PersonDao personDao = PowerMockito.mock(PersonDao.class);
//    PersonDao personDao = Mockito.mock(PersonDao.class);
    System.out.println(personDao.getClass());
    whenNew(PersonDao.class).withNoArguments().thenReturn(personDao);
    doReturn(person).when(personDao).findPersonById(100000);
    Person personById = personService.findPersonById(100000);
    assertThat(personById, equalTo(person));
  }

  @Test
  public void insertPersonTest() throws Exception {
    PersonService personService = new PersonService();
    Person person = new Person();
    person.setId(100000);
    PersonDao personDao = mock(PersonDao.class);
    whenNew(PersonDao.class).withNoArguments().thenReturn(personDao);
    doReturn(true).when(personDao).insertPerson(person);
    Boolean insertPerson = personService.insertPerson(person);
    assertThat(true, equalTo(insertPerson));
  }

  @Test
  public void createPersonTest() throws Exception {
    PersonService personService = new PersonService();
    PersonDao personDao = mock(PersonDao.class);
    whenNew(PersonDao.class).withNoArguments().thenReturn(personDao);
    doNothing().when(personDao).createPerson(100001);
    personService.createPerson(100001);
    Mockito.verify(personDao).createPerson(100001);
  }

  @Test
  public void updatePersonTest(){
    mockStatic(PersonDao.class);
    Person person = new Person();
    person.setId(100000);
    when(PersonDao.updatePerson(person)).thenReturn(true);
    PersonService personService = new PersonService();
    Boolean result = personService.updatePerson(person);
    assertThat(true, equalTo(result));
  }

  @Test
  public void deletePersonTest() throws Exception {
    mockStatic(PersonDao.class);
    doNothing().when(PersonDao.class, "deletePersonById", 100000);
    PersonService personService = new PersonService();
    personService.deletePersonById(100000);
    verifyStatic(Mockito.times(1));
    PersonDao.deletePersonById(100000);
    verifyStatic(Mockito.times(2));
  }


}
