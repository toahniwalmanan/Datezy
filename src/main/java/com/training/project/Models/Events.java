package com.training.project.Models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(nullable = false)
    private LocalDate eventDate;

    @Column(nullable = false)
    private String eventName;

    public Events() {}

    public Events(LocalDate eventDate, String eventName) {
        this.eventDate = eventDate;
        this.eventName = eventName;
    }

    public Long getEventId() {
        return eventId;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
