package models;

import models.enums.CategoryEvents;

import java.time.LocalDateTime;

public class Events {
    private String nameEvent;
    private String addressEvent;
    private CategoryEvents categoryEvents;
    private LocalDateTime timeEvent;
    private String descriptionEvent;

    public Events(String nameEvent, String addressEvent, CategoryEvents categoryEvents, LocalDateTime timeEvent, String descriptionEvent) {
        this.nameEvent = nameEvent;
        this.addressEvent = addressEvent;
        this.categoryEvents = categoryEvents;
        this.timeEvent = timeEvent;
        this.descriptionEvent = descriptionEvent;
    }

    public String toFileString() {
        return nameEvent + ";" + addressEvent + ";" + categoryEvents + ";" + timeEvent + ";" + descriptionEvent;
    }

    public boolean isHappeningNow() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(timeEvent) && now.isBefore(timeEvent.plusHours(1));
    }

    public boolean hasPassed() {
        return LocalDateTime.now().isAfter(timeEvent.plusHours(1));
    }

    public String getNameEvent() {
        return nameEvent;
    }


    public CategoryEvents getCategoryEvents() {
        return categoryEvents;
    }


    public LocalDateTime getTimeEvent() {
        return timeEvent;
    }


}
