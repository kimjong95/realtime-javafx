package service;

import lombok.Getter;

import java.util.function.Consumer;

@Getter
public class EventListener {
    //
    private String id;
    private String groupIdentifier;
    private Consumer consumer;

    public EventListener(String groupIdentifier, Consumer consumer) {
        this.id = consumer.getClass().getName() + (groupIdentifier == null ? "" : groupIdentifier);
        this.groupIdentifier = groupIdentifier;
        this.consumer = consumer;
    }

    public boolean isOwnConsumer(String groupIdentifier, Consumer consumer) {
        return id.equals(consumer.getClass().getName() + (groupIdentifier == null ? "" : groupIdentifier));
    }
}
