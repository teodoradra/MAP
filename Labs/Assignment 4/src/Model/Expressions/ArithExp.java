package Model.Expressions;

import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.MyException;
import Model.Type.IntType;
import Model.Value.IntValue;
import Model.Value.Value;

public class ArithExp implements Exp {
    private Exp e1;
    private Exp e2;
    private int op; //1-plus, 2-minus, 3-star, 4-divide

    public ArithExp(int o, Exp ex1, Exp ex2) {
        op = o;
        e1 = ex1;
        e2 = ex2;
    }

    public Value eval(MyIDictionary<String, Value> tbl, HeapI<Integer,Value> heap) throws MyException {
        Value v1, v2;
        v1 = e1.eval(tbl,heap);
        if (v1.getType().equals(new IntType())) {
            v2 = e2.eval(tbl,heap);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();
                if (op == 1) return new IntValue(n1 + n2);
                if (op == 2) return new IntValue(n1 - n2);
                if (op == 3) return new IntValue(n1 * n2);
                if (op == 4 && n2 == 0) {
                    throw new MyException("division by zero");
                }else {
                        return new IntValue(n1 / n2);
                }

            } else
                throw new MyException("second operand is not an integer");
        } else
            throw new MyException("first operand is not an integer");

    }


    @Override
    public String toString() {
        String buffer = "( " + e1.toString();
        switch (op)
        {
            case 1:
                buffer += " + ";
                break;
            case 2:
                buffer += " - ";
                break;
            case 3:
                buffer += " * ";
                break;
            case 4:
                buffer += " / ";
                break;
            default:
                break;
        }
        buffer += e2.toString() + " )";
        return buffer;
    }

}
