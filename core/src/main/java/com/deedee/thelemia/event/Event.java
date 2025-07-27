package com.deedee.thelemia.event;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Event implements IEvent {
    private final ZonedDateTime timestamp;

    public Event() {
        this.timestamp = ZonedDateTime.now();
    }

    @Override
    public String getTimestamp() {
        return timestamp.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
    @Override
    public abstract String getLog();
}
