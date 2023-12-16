package com.topic.calendarevents.repository;

import com.topic.calendarevents.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Event, Long> { }
