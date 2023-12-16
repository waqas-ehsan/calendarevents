package com.topic.calendarevents.service.impl;

import com.topic.calendarevents.entities.Event;
import com.topic.calendarevents.repository.EventsRepository;
import com.topic.calendarevents.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventRepository;

    @Override
    public Collection<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEvent(Long Id) {
        return eventRepository.findById(Id);
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public boolean deleteEvent(Long Id) {
        eventRepository.deleteById(Id);
        return true;
    }
}
