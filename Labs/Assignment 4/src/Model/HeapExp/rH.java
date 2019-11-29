package Model.HeapExp;
import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.Expressions.Exp;
import Model.MyException;
import Model.Type.RefType;
import Model.Value.RefValue;
import Model.Value.Value;

public class rH implements Exp{
    private Exp exp;

    public rH(Exp e){exp = e;}

    @Override
    public Value eval(MyIDictionary<String,Value> sybTbl, HeapI<Integer,Value> heap) throws MyException {
        Value val = exp.eval(sybTbl, heap);

//        if (!(val.getType().equals(new RefType(new IntType())) || val.getType().equals(new RefType(new RefType(new IntType())))))
//            throw new MyException("Exp is not Ref value\n");

        if (!(val.getType() instanceof RefType))
            throw new MyException("Exp is not Ref value\n");

        RefValue ref = (RefValue) val;
        int add = ref.getAddress();

        if (heap.isDefined(add))
            throw new MyException("Memory not allocated in segment address " + add);

        return heap.get(add);
    }

    @Override
    public String toString(){
        return "rH( " + exp.toString() + ") ";
    }
}
