package Model.DataStructures;

import java.util.List;
import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    private Stack<T> stack; //a field whose type CollectionType is an appropriate
                    // generic java library collection
    public MyStack(){
        stack = new Stack<>();
    }
    @Override
    public void push(T v){
        stack.push(v);
    }

    @Override
    public T pop(){
        return stack.pop();
    }

    @Override
    public boolean isEmpty(){return stack.isEmpty();}

    @Override
    public List<T> getAll(){return stack;}

    @Override
    public String toString() {
        Stack<T> auxiliaryStack = new Stack<>();
        StringBuilder buffer = new StringBuilder();

        while(!stack.isEmpty())
        {
            auxiliaryStack.push(stack.pop());
            buffer.append(auxiliaryStack.peek().toString()).append("\n");
        }

        while(!auxiliaryStack.isEmpty())
            stack.push(auxiliaryStack.pop());

        return buffer.toString();

    }
}
