package rupture.attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Attribute<T> {
    private T baseValue;
    private final List<Function<T, T>> modifiers = new ArrayList<>();

    public Attribute(T baseValue) {
        this.baseValue = baseValue;
    }

    public void setBaseValue(T value) {
        this.baseValue = value;
    }

    public T getBaseValue() {
        return baseValue;
    }

    public void addModifier(Function<T, T> modifier) {
        modifiers.add(modifier);
    }

    public void removeModifier(Function<T, T> modifier) {
        modifiers.remove(modifier);
    }

    public T getFinalValue() {
        T value = baseValue;
        for (Function<T, T> mod : modifiers) {
            value = mod.apply(value);
        }
        return value;
    }
}
