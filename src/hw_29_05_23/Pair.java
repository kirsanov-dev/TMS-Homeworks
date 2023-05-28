package hw_29_05_23;

/*
Написать класс, в котором будет 2 поля и при создании экземпляра такого класса можно указать типы его полей (Аналог
класса Pair<T, K> в котлин)
 */

import java.util.Objects;

public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public Pair copy() {
        return new Pair(this.first, this.second);
    }

    @Override
    public boolean equals(Object obj) {
        // check if the same reference
        if (this == obj) return true;
        // check if object is null or belong to different classes
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // type casting
        Pair<?, ?> otherPair = (Pair<?, ?>) obj;
        // values' comparison
        return Objects.equals(first, otherPair.first) && Objects.equals(second, otherPair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
