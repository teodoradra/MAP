package Model.DataStructures;

import Model.MyException;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MyIDictionary<T, T2> {
    T2 lookup(T id) throws MyException;

    String toString();

    Set<T> keySet();
    Iterable<Map.Entry<T, T2>> getAll();
    T2 get(T key);
    boolean isDefined(T val);
    void update(T key, T2 val);
    void remove(T key);
    T2 add(T key, T2 val);

    Collection<T2> getDictVal();
}
