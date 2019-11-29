package HeapStmt;

import Controller.PrgState;
import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.Expressions.Exp;
import Model.MyException;
import Model.ProgramStatement.IStmt;
import Model.Type.RefType;
import Model.Value.RefValue;
import Model.Value.Value;

public class New implements IStmt {
    private static int uniqId = 1;

    private String var_name;
    private Exp exp ;

    public New(String var, Exp e){
        var_name = var;
        exp = e;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> symTbl = state.getSymbolTable();
        HeapI<Integer, Value> heap = state.getHeap();

        if(symTbl.lookup(var_name)== null)
            throw new MyException("Not in SymTbl!\n");
        Value val = exp.eval(symTbl,heap);

        if (!(symTbl.lookup(var_name).getType() instanceof RefType))
            throw new MyException("Val is not a Ref type!\n");

        //        if (!(val.getType().equals((((RefValue)symTbl.get(var_name)).getLocationType()))))
//                throw new MyException("Exp is not the same type\n");



        heap.add(uniqId,val);
        Value value = symTbl.get(var_name);
        //RefValue refValue = (RefValue) value;
        RefValue newRefVal = new RefValue(uniqId,value.getType());
        // UPDATE VERSION
        symTbl.update(var_name,newRefVal);

        //CHANGE ALL VERSION
        //refValue.setAddress(uniqId);
        uniqId++;

        state.setSymbolTable(symTbl);
        state.setHeap(heap);

        return state;
    }

    @Override
    public String toString(){
        return "new( " + var_name + ", " + exp + " )";
    }
}
