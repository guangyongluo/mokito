package com.vilin.demo.test;

import com.vilin.demo.dao.PeopleDao;
import com.vilin.demo.entity.People;
import com.vilin.demo.service.PeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PeopleDao.class})
public class PeopleTest {

//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//    @Test
//    public void peopleInsertTestByMockito(){
//        PeopleDao peopleDao = Mockito.mock(PeopleDao.class);
//        PeopleService peopleService = new PeopleService(peopleDao);
//        People people = new People();
//        people.setName("Leo");
//        people.setAge(37);
//        Mockito.doNothing().when(peopleDao).insertPeople(people);
//        peopleService.insertPeople(people);
//        Mockito.verify(peopleDao).insertPeople(people);
//    }

    @Test
    public void peopleInsertTestByPowerMock(){
        PeopleDao peopleDao = PowerMockito.mock(PeopleDao.class);
//        System.out.println(peopleDao.getClass());
        PeopleService peopleService = new PeopleService(peopleDao);
        People people = new People();
        people.setName("Leo");
        people.setAge(37);
        PowerMockito.doNothing().when(peopleDao).insertPeople(people);
        peopleService.insertPeople(people);
        Mockito.verify(peopleDao).insertPeople(people);
    }
}
