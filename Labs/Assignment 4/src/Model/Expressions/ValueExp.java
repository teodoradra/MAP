package Model.Expressions;

import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.MyException;
import Model.Value.Value;

public class ValueExp implements Exp {
    private Value e;

    public ValueExp(Value e){
        this.e = e;
    }
    public Value eval(MyIDictionary<String,Value> tbl, HeapI<Integer,Value> heap) throws MyException {
        return e;
    }

    @Override
    public String toString() {
        return "" + e;
    }
}
