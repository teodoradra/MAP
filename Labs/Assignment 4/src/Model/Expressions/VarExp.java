package Model.Expressions;

import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.MyException;
import Model.Value.Value;

public class VarExp implements Exp {
    private String id;

    public VarExp(String id){
        this.id = id;
    }
    public Value eval(MyIDictionary<String,Value> tbl, HeapI<Integer,Value> heap) throws MyException{
        return tbl.lookup(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
