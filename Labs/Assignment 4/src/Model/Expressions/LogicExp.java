package Model.Expressions;

import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.MyException;
import Model.Type.BoolType;
import Model.Value.BoolValue;
import Model.Value.Value;

public class LogicExp implements Exp{
    private Exp e1;
    private Exp e2;
    private String op;

    public Value eval(MyIDictionary<String,Value> tbl, HeapI<Integer,Value> heap) throws MyException{
        Value v1,v2;
        v1 = e1.eval(tbl,heap);
        if(v1.getType().equals(new BoolType())){
            v2 = e2.eval(tbl,heap);
            if (v2.getType().equals(new BoolType())){
                boolean n1,n2;
                n1= ((BoolValue) v1).getVal();
                n2= ((BoolValue) v2).getVal();
                if (op.equals("&&")){
                    boolean b = n1 && n2;
                    return new BoolValue(b);
                }
                if (op.equals("||")){
                    boolean b = n1 || n2;
                    return new BoolValue(b);
                }
            }else
                throw  new MyException("Operand 2 is not boolean!");
        }else
            throw new MyException("Operand 1 is not boolean!");
        throw  new MyException("");
    }

    @Override
    public String toString() {
        return "( " + e1.toString() + " " + op + " " + e2.toString() + " )";
    }
}
