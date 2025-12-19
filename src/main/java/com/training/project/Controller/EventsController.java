package com.training.project.Controller;


import com.training.project.Models.Events;
import com.training.project.Services.EventsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventsServices eventService;

    //Create Event
    @PostMapping("/create")
    public String createEvent(@RequestBody Events event) {
        return eventService.createEvent(event);
    }

    //Update Event (PATCHer)
    @PatchMapping("/update/{id}")
    public String updateEvent(@PathVariable Long id,
                              @RequestBody Events event) {
        return eventService.updateEvent(id, event);
    }

    //Delete Event
    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event deleted successfully";
    }

    //Show All Events
    @GetMapping("/all")
    public List<Events> getAllEvents() {
        return eventService.getAllEvents();
    }

    //Show Upcoming 5 Events
    @GetMapping("/upcoming")
    public List<Events> getUpcomingEvents() {
        return eventService.getUpcomingEvents();
    }
}
