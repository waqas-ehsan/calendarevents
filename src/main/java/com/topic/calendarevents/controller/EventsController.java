package com.topic.calendarevents.controller;

import com.topic.calendarevents.entities.Event;
import com.topic.calendarevents.exception.EventsException;
import com.topic.calendarevents.service.EventsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EventsController {

    private final Logger log = LoggerFactory.getLogger(EventsController.class);
    @Autowired
    private EventsService eventsService;

    @RequestMapping(method = RequestMethod.GET, value = "/events")
    Collection<Event> events() {
        return eventsService.getEvents();
    }

    @RequestMapping(method = RequestMethod.GET , value = "/event/{id}")
    ResponseEntity<?> getEvent(@PathVariable Long id) {
        Optional<Event> event = eventsService.getEvent(id);
        return event.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST,  value = "/event")
    ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) throws URISyntaxException {
        log.info("Request to create event: {}", event);
        try {
            Event result = eventsService.createEvent(event);
            return ResponseEntity.created(new URI("/api/event/" + result.getEventId()))
                    .body(result);
        }catch (RuntimeException exception){
            new EventsException(exception.getMessage());
        }
        return ResponseEntity.internalServerError().body(null);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/event/{id}")
    ResponseEntity<Event> updateEvent(@Valid @RequestBody Event event) {
        log.info("Request to update event: {}", event);
        try {
            Event result = eventsService.updateEvent(event);
            return ResponseEntity.ok().body(result);
        }catch (RuntimeException exception){
            throw new EventsException(exception.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/event/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        log.info("Request to delete Event: {}", id);
        eventsService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }

}
