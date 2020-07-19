package com.depa.observer;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CustomSpringEvent extends ApplicationEvent {
    private final String name;

    public CustomSpringEvent(Object source, String name) {
        super(source);
        this.name = name;
        System.out.println("new event: " + name );
    }
}
