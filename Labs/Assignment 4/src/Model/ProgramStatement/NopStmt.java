package Model.ProgramStatement;

import Controller.PrgState;
import Model.MyException;

public class NopStmt implements IStmt {
    public PrgState execute(PrgState state) throws MyException{
        return state;
    }
}
