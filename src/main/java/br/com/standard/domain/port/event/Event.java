package br.com.standard.domain.port.event;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Event {
    private Date timestamp;
    private String eventType;

    protected Event() {
        this.timestamp = new Date();
        this.eventType = this.getClass().getName();
    }
}
