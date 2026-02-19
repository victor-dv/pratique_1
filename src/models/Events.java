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
        return nameEvent + ";" + addressEvent + ";" + categoryEvents + ";" + timeEvent + ";" + descriptionEvent;    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getAddressEvent() {
        return addressEvent;
    }

    public void setAddressEvent(String addressEvent) {
        this.addressEvent = addressEvent;
    }

    public CategoryEvents getCategoryEvents() {
        return categoryEvents;
    }

    public void setCategoryEvents(CategoryEvents categoryEvents) {
        this.categoryEvents = categoryEvents;
    }

    public LocalDateTime getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(LocalDateTime timeEvent) {
        this.timeEvent = timeEvent;
    }

    public String getDescriptionEvent() {
        return descriptionEvent;
    }

    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }
}
