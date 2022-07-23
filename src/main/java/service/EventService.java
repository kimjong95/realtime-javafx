package service;

import java.util.*;
import java.util.function.Consumer;

public class EventService {
    //
    private static EventService instance = new EventService();

    private Map<Class, List<EventListener>> listenersMap = new HashMap<>();

    private EventService() {
        //
    }

    public static EventService getInstance() {
        //
        return instance;
    }

    private List<EventListener> getListeners(Class clazz) {
        //
        if(listenersMap.containsKey(clazz)) {
            return listenersMap.get(clazz);
        }

        listenersMap.put(clazz, new ArrayList<>());
        return listenersMap.get(clazz);
    }

    private Optional<EventListener> find(List<EventListener> listeners, String identifier, Consumer consumer) {
        //
        for(EventListener listener : listeners) {
            if(listener.isOwnConsumer(identifier, consumer)) {
                return Optional.of(listener);
            }
        }
        return Optional.empty();
    }

    private boolean listenerContains(List<EventListener> listeners, String identifier, Consumer consumer) {
        for(EventListener listener : listeners) {
            if(listener.isOwnConsumer(identifier, consumer)) {
                return true;
            }
        }
        return false;
    }

    public <T> void addSelectEventListener(Class<T> clazz, Consumer<T> consumer) {
        addSelectEventListener(clazz, null, consumer);
    }

    public <T> void addSelectEventListener(Class<T> clazz, String identifier, Consumer<T> consumer) {
        //
        List<EventListener> listeners = getListeners(clazz);
        if(listenerContains(listeners, identifier, consumer)) {
            removeSelectEventListener(clazz, identifier, consumer);
        }

        System.out.println("add listener --> " + consumer);
        listeners.add(new EventListener(identifier, consumer));
    }

    public <T> void removeSelectEventListener(Class<T> clazz, Consumer<T> consumer) {
        removeSelectEventListener(clazz, null, consumer);
    }

    public <T> void removeSelectEventListener(Class<T> clazz, String identifier, Consumer<T> consumer) {
        System.out.println("remove listener --> " + consumer);
        List<EventListener> listeners = getListeners(clazz);
        find(listeners, identifier, consumer).ifPresent(listeners::remove);
    }

    public <T> void fire(T selectedObject) {
        fire(selectedObject, null);
    }

    public <T> void fire(T selectedObject, String targetIdentifier) {
        Class<?> type = selectedObject.getClass();
        List<EventListener> listeners = getListeners(type);
        if(targetIdentifier != null) {
            listeners.stream()
                    .filter(listener -> listener.getGroupIdentifier().equals(targetIdentifier))
                    .forEach(listener -> listener.getConsumer().accept(selectedObject));
        } else {
            listeners.forEach(listener -> listener.getConsumer().accept(selectedObject));
        }
    }

    public <T> void fireNull(Class<?> type) {
        fireNull(type, null);
    }

    public <T> void fireNull(Class<?> type, String targetIdentifier) {
        List<EventListener> listeners = getListeners(type);
        if(targetIdentifier != null) {
            listeners.stream()
                    .filter(listener -> listener.getGroupIdentifier().equals(targetIdentifier))
                    .forEach(listener -> listener.getConsumer().accept(null));
        } else {
            listeners.forEach(listener -> listener.getConsumer().accept(null));
        }
    }

    public static void main(String[] args) {
        EventService.getInstance().addSelectEventListener(Date.class, System.out::println);
        EventService.getInstance().fire(new Date());
    }
}
