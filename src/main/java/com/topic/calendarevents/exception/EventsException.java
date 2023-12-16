package com.topic.calendarevents.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class EventsException extends RuntimeException{
    public EventsException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
