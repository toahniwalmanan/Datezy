package com.training.project.Services;



import com.training.project.Models.Events;
import com.training.project.Repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventsServices {

    @Autowired
    private EventsRepository eventRepository;

    // 1. Create Event
    public String createEvent(Events event) {
        eventRepository.save(event);
        return "Event Created";
    }

    // 2. Update Event (PATCH)
    public String updateEvent(Long id, Events updatedEvent) {
        Optional<Events> optionalEvent = eventRepository.findById(id);

        if (optionalEvent.isPresent()) {
            Events existingEvent = optionalEvent.get();

            if (updatedEvent.getEventDate() != null) {
                existingEvent.setEventDate(updatedEvent.getEventDate());
            }
            if (updatedEvent.getEventName() != null) {
                existingEvent.setEventName(updatedEvent.getEventName());
            }

            eventRepository.save(existingEvent);
            return "Event is updated";
        }
        return "Event Doesn't exist";
    }

    // 3. Delete Event
    public String deleteEvent(Long id) {
        eventRepository.deleteById(id);
        return "Event Deleted";
    }

    // 4. Show All Events
    public List<Events> getAllEvents() {
        return eventRepository.findAll();
    }

    // 5. Show Upcoming 5 Events
    public List<Events> getUpcomingEvents() {
        return eventRepository.findTop5ByEventDateAfterOrderByEventDateAsc(LocalDate.now());
    }
}

