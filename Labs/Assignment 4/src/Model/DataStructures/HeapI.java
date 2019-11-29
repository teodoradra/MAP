package Model.DataStructures;

import Model.MyException;

import java.util.Map;
import java.util.Set;

public interface HeapI<K,V> {
    V lookup(K id) throws MyException;
    Set<K> keySet();
    //Iterable<Map.Entry<T, T2>> getAll();
    V get(K key);
    boolean isDefined(K val);
    V update(K key, V val);
    void remove(K key);
    V add(K key, V val);
    void setHeapContent(Map<K,V> heap);

    String toString();

    Map<K,V> getHeap();
}
