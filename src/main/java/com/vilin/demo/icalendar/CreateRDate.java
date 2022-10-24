package com.vilin.demo.icalendar;

import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.Value;
import net.fortuna.ical4j.model.property.*;
import net.fortuna.ical4j.util.FixedUidGenerator;

import java.net.SocketException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateRDate {

  public static void main(String[] args) throws ParseException, SocketException {

    Calendar calendar = new Calendar();
    calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
    calendar.getProperties().add(Version.VERSION_2_0);
    calendar.getProperties().add(CalScale.GREGORIAN);

    PeriodList periodList = new PeriodList();
    DateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm");
    DateTime startDate1 = new DateTime(format.parse(("11/09/2009 08:00")));
    DateTime startDate2 = new DateTime(format.parse(("11/10/2009 09:00")));
    DateTime endDate1 = new DateTime(format.parse(("11/09/2009 09:00")));
    DateTime endDate2 = new DateTime(format.parse(("11/10/2009 11:00")));
    periodList.add(new Period(startDate1, endDate1));
    periodList.add(new Period(startDate2, endDate2));

    VEvent event = new VEvent(startDate1, endDate1, "event subject");
    event.getProperties().add(new Uid(new FixedUidGenerator("iCal4j").generateUid().getValue()));

    ParameterList paraList = new ParameterList();
    paraList.add(Value.PERIOD);
    RDate rdate = new RDate(paraList, periodList);
    event.getProperties().add(rdate);
    calendar.getComponents().add(event);

    // 验证
    calendar.validate();
    System.out.println(calendar);
  }
}
