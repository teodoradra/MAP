package Model.ProgramStatement;

import Controller.PrgState;
import Model.DataStructures.MyIStack;
import Model.MyException;

public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt snd;

    public CompStmt(IStmt fir, IStmt sc) {
        first = fir;
        snd = sc;
    }

    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk=state.getExecutionStack();
        stk.push(snd);
        stk.push(first);
        return state;
    }

    @Override
    public String toString()
    {
        return first.toString() + "\n" + snd.toString();
    }
}

