package com.deedee.thelemia.event;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Event {
    private final ZonedDateTime timestamp;

    public Event() {
        this.timestamp = ZonedDateTime.now();
    }

    public String getTimestamp() {
        return timestamp.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
    public abstract String getLog();
}
