package com.vilin.demo.icalendar;

import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.parameter.Cn;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.util.FixedUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;

import java.net.SocketException;
import java.net.URI;
import java.util.GregorianCalendar;

public class CreateEvent {

  public static void main(String[] args) throws SocketException {
    // 创建一个时区（TimeZone）
    TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
    TimeZone timezone = registry.getTimeZone("America/Mexico_City");
    VTimeZone tz = timezone.getVTimeZone();

    // 起始时间是：2008 年 4 月 1 日 上午 9 点
    java.util.Calendar startDate = new GregorianCalendar();
    startDate.setTimeZone(timezone);
    startDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL);
    startDate.set(java.util.Calendar.DAY_OF_MONTH, 1);
    startDate.set(java.util.Calendar.YEAR, 2008);
    startDate.set(java.util.Calendar.HOUR_OF_DAY, 9);
    startDate.set(java.util.Calendar.MINUTE, 0);
    startDate.set(java.util.Calendar.SECOND, 0);

    // 结束时间是：2008 年 4 月 1 日 下午 1 点
    java.util.Calendar endDate = new GregorianCalendar();
    endDate.setTimeZone(timezone);
    endDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL);
    endDate.set(java.util.Calendar.DAY_OF_MONTH, 1);
    endDate.set(java.util.Calendar.YEAR, 2008);
    endDate.set(java.util.Calendar.HOUR_OF_DAY, 13);
    endDate.set(java.util.Calendar.MINUTE, 0);
    endDate.set(java.util.Calendar.SECOND, 0);

    // 创建事件
    String eventName = "Progress Meeting";
    DateTime start = new DateTime(startDate.getTime());
    DateTime end = new DateTime(endDate.getTime());
    VEvent meeting = new VEvent(start, end, eventName);

    // 添加时区信息
    meeting.getProperties().add(tz.getTimeZoneId());

    // 生成唯一标志符
    UidGenerator ug = new FixedUidGenerator("uidGen");
    Uid uid = ug.generateUid();
    meeting.getProperties().add(uid);

    // 添加参加者 .
    Attendee dev1 = new Attendee(URI.create("mailto:dev1@mycompany.com"));
    dev1.getParameters().add(Role.REQ_PARTICIPANT);
    dev1.getParameters().add(new Cn("Developer 1"));
    meeting.getProperties().add(dev1);

    Attendee dev2 = new Attendee(URI.create("mailto:dev2@mycompany.com"));
    dev2.getParameters().add(Role.OPT_PARTICIPANT);
    dev2.getParameters().add(new Cn("Developer 2"));
    meeting.getProperties().add(dev2);

    // 创建日历
    Calendar icsCalendar = new Calendar();
    icsCalendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));
    icsCalendar.getProperties().add(CalScale.GREGORIAN);

    // 添加事件
    icsCalendar.getComponents().add(meeting);

    System.out.println(icsCalendar);
  }
}
