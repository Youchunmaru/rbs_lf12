package de.rbsulm.rbs_lf12.model;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
public class ThymeCalendarEvent {
    private String title;
    private String description;
    private String location;
    private String startDate;
    private CalendarCategory category;

    public ThymeCalendarEvent(CalendarEvent calendarEvent) {
        this.title = calendarEvent.getTitle();
        this.description = calendarEvent.getDescription();
        this.location = calendarEvent.getLocation();
        this.startDate = LocalDateTime.ofEpochSecond(calendarEvent.getStartDate() / 1000,0, ZoneOffset.UTC).format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        );
        this.category = calendarEvent.getCategory();
    }
    public ThymeCalendarEvent(){}
}
