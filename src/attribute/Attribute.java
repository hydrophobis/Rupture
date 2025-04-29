package attribute;

public class Attribute<T> {
    private T value;
    private final T base;

    public Attribute(T value) {
        this.value = value;
        this.base = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T getBase() {
        return base;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    // Factory methods
    public static Attribute<Double> health(double d) {
        return new Attribute<>(d);
    }

    public static Attribute<Double> damage(double d) {
        return new Attribute<>(d);
    }

    public static Attribute<Integer> turns(int i) {
        return new Attribute<>(i);
    }

    public static <T> Attribute<T> create(String name, T val) {
        return new Attribute<>(val);
    }
}
