package Model.Expressions;

import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.MyException;
import Model.Value.Value;

public interface Exp {
    Value eval(MyIDictionary<String,Value> tbl, HeapI<Integer,Value> heap) throws MyException;

}
