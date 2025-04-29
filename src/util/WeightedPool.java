package util;

import java.util.*;

public class WeightedPool<T> {
    private static class Entry<T> {
        T item;
        int weight;

        Entry(T item, int weight) {
            this.item = item;
            this.weight = weight;
        }
    }

    private final List<Entry<T>> entries = new ArrayList<>();
    private int totalWeight = 0;
    private final Random random = new Random();

    public void add(T item, int weight) {
        if (weight <= 0) throw new IllegalArgumentException("Weight must be positive");
        entries.add(new Entry<>(item, weight));
        totalWeight += weight;
    }

    public T getRandom() {
        int r = random.nextInt(totalWeight);
        int current = 0;
        for (Entry<T> entry : entries) {
            current += entry.weight;
            if (r < current) {
                return entry.item;
            }
        }
        return null; // should never hit this
    }
}
