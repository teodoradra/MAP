package Model.DataStructures;

public interface MyIList<T> {
    boolean add(T t);
    int size();
    boolean isEmpty();
    T get(int index);
    String toString();
}
