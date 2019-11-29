package Model.ProgramStatement;

import Controller.PrgState;
import Model.DataStructures.HeapI;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIStack;
import Model.DataStructures.MyStack;
import Model.Expressions.Exp;
import Model.MyException;
import Model.Type.Type;
import Model.Value.Value;

public class AssignStmt implements IStmt {
    private String id;
    private Exp exp;

    public AssignStmt(String id, Exp e){
        this.id = id;
        this.exp = e;
    }
    public String toString(){ return id+"="+ exp.toString(); }
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk=state.getExecutionStack();
        MyIDictionary<String, Value> symTbl= state.getSymbolTable();
        HeapI<Integer,Value> heap = state.getHeap();

        Value val = exp.eval(symTbl,heap);
        if (symTbl.isDefined(id)) {
            Type typId = (symTbl.get(id)).getType();
            if (val.getType().equals(typId)) {
            symTbl.update(id, val);
            } else
                throw new MyException("declared type of variable" + id + " and type of the assigned expression do not match");
        }
        else
            throw new MyException("the used variable" +id + " was not declared before");
        return state;
        }
}

