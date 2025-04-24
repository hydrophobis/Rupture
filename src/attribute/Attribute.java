package attribute;

public class Attribute<T> {
    public String name;
    public T value;

    public Attribute(T value){
        this.value = value;
    }

    public static Attribute<Integer> intAttribute(int val){
        return new Attribute<Integer>(val);
    }
}
