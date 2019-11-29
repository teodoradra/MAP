package Model.ProgramStatement;
import Controller.PrgState;
import Model.Expressions.Exp;
import Model.MyException;

public class PrintStmt implements IStmt{
    private Exp variableName;

    public PrintStmt(Exp varName){ variableName = varName; }

    @Override
    public String toString(){ return "print(" + variableName +")";}

    @Override
    public PrgState execute(PrgState state) throws MyException{
        state.getOutputList().add(variableName.eval(state.getSymbolTable(),state.getHeap()));
        return null;
    }
}
