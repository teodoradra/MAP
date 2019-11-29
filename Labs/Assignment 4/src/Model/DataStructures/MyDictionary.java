package Model.DataStructures;

import Model.MyException;

import java.util.*;

public class MyDictionary<K, V> implements MyIDictionary<K, V> {
    private Map<K, V> dict;

    public MyDictionary() {
        dict = new HashMap<>();
    }

    public V lookup(K k) throws MyException {
        V v = dict.get(k);
        if (v != null)
            return v;
        else
            throw new MyException("Key not found!\n");
    }

    @Override
    public String toString()
    {
        StringBuilder buffer = new StringBuilder();
        for(K key : this.keySet())
            buffer.append(key.toString()).append(" -> ").append(dict.get(key).toString()).append("\n");

        return buffer.toString();
    }

    @Override
    public Set<K> keySet() {
        return dict.keySet();
    }

    @Override
    public Iterable<Map.Entry<K, V>> getAll() {
        return dict.entrySet();
    }

    @Override
    public V get(K key) {
        return dict.get(key);
    }

    @Override
    public boolean isDefined(K val) {
        return dict.get(val) != null;
    }

    @Override
    public V add(K key, V val){
        return dict.put(key,val);
    }

    @Override
    public void remove(K key){
        dict.remove(key);
    }
    @Override
    public void update(K key, V val) {
        dict.replace(key, val) ;
    }

    @Override
    public Collection<V> getDictVal() {
        return dict.values();
    }
}

