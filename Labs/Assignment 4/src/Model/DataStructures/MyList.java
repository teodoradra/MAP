package Model.DataStructures;

import java.util.ArrayList;

public class MyList<T> implements MyIList<T> {
    private ArrayList<T> list;

    public MyList(){ list = new ArrayList<>(); }

    @Override
    public int size(){return list.size();}

    @Override
    public boolean isEmpty(){return list.isEmpty();}

    @Override
    public boolean add(T t){
        list.add(t);
        return true;
    }

    @Override
    public T get(int index){return list.get(index);}

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        for(T element : list)
            buffer.append(element.toString()).append(" | ");
        return buffer.toString();    }

    //public void pop(){
      //  list.remove();
    //}


}
