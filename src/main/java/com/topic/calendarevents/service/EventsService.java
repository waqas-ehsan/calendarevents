package com.topic.calendarevents.service;

import com.topic.calendarevents.entities.Event;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.Optional;

public interface EventsService {
    Collection<Event> getEvents();
    Optional<Event> getEvent(Long Id);

    Event createEvent(Event event);

    Event updateEvent(Event event);

    boolean deleteEvent(Long Id);
}
