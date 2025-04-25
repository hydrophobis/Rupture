package attribute;

public class Attribute<T> {
    public String name;
    public T value;
    public T base;

    public void set(T value){
        set(name, value);
    }

    public void set(String name, T value){
        this.name = name;
        this.value = value;
    }

    public Attribute(T value){
        this.value = value;
        this.base = value;
    }

    public Attribute(T value, T base){
        this.value = value;
        this.base = base;
    }

    public static Attribute<Integer> intAttribute(int val){
        return new Attribute<Integer>(val);
    }
}
