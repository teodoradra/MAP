package Model.DataStructures;

import Model.MyException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Heap<K,V> implements HeapI<K,V> {
    private static int uniqueId = 1;
    private int itemId;
    private Map<K,V> heap;

    public Heap(){ heap = new HashMap<>();
    }

    @Override
    public V lookup(K key) throws MyException {
        return heap.get(key);
    }

    @Override
    public Set<K> keySet() {
        return heap.keySet();
    }

    @Override
    public boolean isDefined(K key){
        return heap.get(key) == null;
    }

    @Override
    public V get(K key){
        return heap.get(key);
    }

    @Override
    public V update(K key, V value){
        return heap.replace(key,value);
    }

    @Override
    public void remove(K key){
        heap.remove(key);
    }

    @Override
    public V add(K key, V val){
        return heap.put(key,val);
    }

    @Override
    public String toString(){
        StringBuilder buffer = new StringBuilder();
        for(K key : this.keySet())
            buffer.append(key.toString()).append(" -> ").append(heap.get(key).toString()).append("\n");

        return buffer.toString();
    }

    public Map<K, V> getHeap() {
        return heap;
    }

    public void setHeapContent(Map<K,V> newHeap){
        heap = newHeap;
    }
}
