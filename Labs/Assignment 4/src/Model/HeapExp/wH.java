package Model.HeapExp;

import Controller.PrgState;
import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.Expressions.Exp;
import Model.MyException;
import Model.ProgramStatement.IStmt;
import Model.Type.IntType;
import Model.Type.RefType;
import Model.Value.RefValue;
import Model.Value.Value;

import java.io.FileNotFoundException;

public class wH implements IStmt {
    private String var_name;
    private Exp exp;

    public wH(String var, Exp e){
        exp = e;
        var_name = var;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException, FileNotFoundException {
        MyIDictionary<String,Value> tbl = state.getSymbolTable();
        HeapI<Integer,Value> heap = state.getHeap();

        if(!tbl.isDefined(var_name))
            throw new MyException("Var_name not in symbol table!\n");
        Value val = exp.eval(tbl, heap);

        if(!(tbl.get(var_name).getType() instanceof RefType))
            throw new MyException("Not Ref type\n");

        if (!(val.getType().equals(new IntType())))
            throw new MyException("Exp is not Ref type\n");

        Value v = tbl.get(var_name);
        RefValue intAdd = (RefValue) v;


        if(heap.isDefined(intAdd.getAddress()))
            throw new MyException("Addresd not defined" + intAdd);

        heap.update(intAdd.getAddress(),val);


        return state;
    }

    @Override
    public String toString() {
        return "wH( " + var_name + ", " + exp.toString() + ") ";
    }
}

