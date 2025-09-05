package rupture.attribute;

public final class AttributeKey<T> {
    private final String name;
    private final T defaultValue;

    public AttributeKey(String name, T defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String toString() {
        return "AttributeKey(" + name + ")";
    }
}
