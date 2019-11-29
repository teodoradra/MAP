package Model.Expressions;

import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.MyException;
import Model.Type.IntType;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.Value;

public class RelationExp implements Exp {
    private Exp exp1,exp2;
    private String op;

    public RelationExp(String o, Exp e1, Exp e2){
        op = o;
        exp1 = e1;
        exp2 =e2;
    }

    @Override
    public Value eval(MyIDictionary<String,Value> symTbl, HeapI<Integer,Value> heap) throws MyException{
        Value v1, v2;
        v1 = exp1.eval(symTbl,heap);
        if (v1.getType().equals(new IntType())) {
            v2 = exp2.eval(symTbl,heap);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();
                if (op.equals("<")) return new BoolValue(n1 < n2);
                if (op.equals("<=")) return new BoolValue(n1 <= n2);
                if (op.equals("==")) return new BoolValue(n1 == n2);
                if (op.equals("!=")) return new BoolValue(n1 != n2);
                if (op.equals(">")) return new BoolValue(n1 > n2);
                if (op.equals(">=")) return new BoolValue(n1 >= n2);
            } else
                throw new MyException("second operand is not an integer");
        } else
            throw new MyException("first operand is not an integer");
        return null;
    }
}
