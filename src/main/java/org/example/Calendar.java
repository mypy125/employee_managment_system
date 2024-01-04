package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Calendar {
//------------------------------------------region fill
    private Map<LocalDate, Sprint> events;
//------------------------------------------region construction
    public Calendar(){
        this.events = new HashMap<>();
    }
//-------------------------------------------------------region method
    public void addEvent(LocalDate date, Sprint event) {
        events.put(date, event);
    }
    public void viewCalendar(LocalDate month) {
        System.out.println("Calendar for " + month.getMonth() + " " + month.getYear());
        System.out.println("----------------------------");

        LocalDate firstDayOfMonth = month.withDayOfMonth(1);
        LocalDate lastDayOfMonth = month.withDayOfMonth(month.lengthOfMonth());

        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            Sprint event = events.get(date);
            System.out.printf("%3d: %s%n", date.getDayOfMonth(), event != null ? event : "");
        }
    }
}
