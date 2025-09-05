package rupture.attribute;

import java.util.HashMap;
import java.util.Map;

public class AttributeContainer {
    private final Map<AttributeKey<?>, Attribute<?>> attributes = new HashMap<>();

    public <T> void set(AttributeKey<T> key, T value) {
        attributes.put(key, new Attribute<>(value));
    }

    @SuppressWarnings("unchecked")
    public <T> Attribute<T> get(AttributeKey<T> key) {
        return (Attribute<T>) attributes.computeIfAbsent(
            key,
            k -> new Attribute<>(k.getDefaultValue())
        );
    }

    public <T> T getFinal(AttributeKey<T> key) {
        return get(key).getFinalValue();
    }
}
