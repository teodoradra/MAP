package Model.ProgramStatement;

import Controller.PrgState;
import Model.Expressions.Exp;
import Model.MyException;
import Model.Value.BoolValue;
import Model.Value.Value;

public class IfStmt implements IStmt{
    private Exp exp;
    private IStmt thenS;
    private IStmt elseS;

    public IfStmt(Exp e, IStmt t, IStmt el) {exp=e; thenS=t;elseS=el;}
    public String toString(){ return "IF("+ exp.toString()+") THEN(" +thenS.toString() +")ELSE("+elseS.toString()+")";}
    public PrgState execute(PrgState state) throws MyException {
        Value value;
        value = exp.eval(state.getSymbolTable(),state.getHeap());
        boolean val2;

        BoolValue b1 = (BoolValue)value;
        val2 = b1.getVal();

        if(val2) state.getExecutionStack().push(thenS);
        else state.getExecutionStack().push(elseS);
        return null;
    }

}
