package com.vilin.demo.icalendar;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.*;
import net.fortuna.ical4j.util.FixedUidGenerator;

import java.net.SocketException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateRRule {

  public static void main(String[] args) throws ParseException, SocketException {

    Calendar calendar = new Calendar();
    DateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
    DateTime start = new DateTime(format.parse("11/09/2009 08:00").getTime());
    DateTime end = new DateTime(format.parse("11/09/2009 09:00").getTime());
    calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
    calendar.getProperties().add(Version.VERSION_2_0);
    calendar.getProperties().add(CalScale.GREGORIAN);

    VEvent event = new VEvent(start, end, "event subject");
    event.getProperties().add(new Uid(new FixedUidGenerator("iCal4j").generateUid().getValue()));

    Recur recur = new Recur(Recur.Frequency.WEEKLY, 4);

    RRule rule = new RRule(recur);
    event.getProperties().add(rule);
    calendar.getComponents().add(event);
  }
}
