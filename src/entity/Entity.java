package entity;

import java.util.*;

import attribute.Attribute;

public class Entity {
    public String name;

    private final Map<String, Attribute<?>> attributes = new HashMap<>();

    // Add an attribute
    public <T> void setAttribute(String name, Attribute<T> value) {
        attributes.put(name, value);
    }

    // Get an attribute
    public Attribute<?> getAttribute(String name) {
        return attributes.get(name);
    }

    // Get just the value with cast
    @SuppressWarnings("unchecked")
    public <T> T getValue(String name) {
        Attribute<?> attr = attributes.get(name);
        return attr != null ? ((Attribute<T>) attr).get() : null;
    }

    // Modify the value
    @SuppressWarnings("unchecked")
    public <T> void setValue(String name, T value) {
        Attribute<?> attr = attributes.get(name);
        if (attr != null) ((Attribute<T>) attr).set(value);
    }
    
    public Entity(String name){
        this.name = name;
    }
}
