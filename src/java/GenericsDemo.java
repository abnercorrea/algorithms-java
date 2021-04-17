package java;

import java.util.Set;

public class GenericsDemo<T> {

    T value = null;
    Set<T> values;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public T getValue() {
        return value;
    }

    public void setValue(T newValue) {
        value = newValue;
    }

    public <N extends Number> long round(N number) {
        return Math.round((double) number);
    }

    public <S extends Set<T>> boolean containsAll(S set) {
        return values.containsAll(set);
    }


}
